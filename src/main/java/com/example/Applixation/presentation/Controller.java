package com.example.Applixation.presentation;

import com.example.Applixation.entities.*;
import com.example.Applixation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ClientService clientService;

    @Autowired
    TypeAgentService typeAgentService;

    @Autowired
    MotifVoyageService motifVoyageService;

    @Autowired
    DestinationService destinationService;

    @Autowired
    AgentService agentService;

    @Autowired
    ProcedureService procedureService;

    @Autowired
    ObservationService observationService;

    //////////////////////////////////CLIENT//////////////////////////////////////////////////////////////////////
    @RequestMapping("/")
    public String viewhomePage(Model model){
        List<Client> listClient = clientService.clientList();
        model.addAttribute("listClient",listClient );

        return "index";
    }

    @RequestMapping("/newClient")
    public String ShowNewClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_Client";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String SaveClient(@ModelAttribute("client") Client client){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        Date date = new Date();
        client.setDateCreation(format.format(date));
        clientService.save(client);

        return "redirect:/";
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////TYPE AGENT/////////////////////////////////////////////////////////////////

    @RequestMapping("/typeAgent")
    public String viewPageTypeAgent(Model model){
        List<TypeAgent> typeAgentList = typeAgentService.TypeAgentList();
        model.addAttribute("typeAgentList",typeAgentList );

        return "typeAgent";
    }

    @RequestMapping("/newTypeAgent")
    public String ShowNewTypeAgentForm(Model model){
        TypeAgent typeAgent = new TypeAgent();
        model.addAttribute("typeAgent", typeAgent);
        return "new_typeAgent";
    }

    @RequestMapping(value = "/saveTypeagent", method = RequestMethod.POST)
    public String SaveTypeagent(@ModelAttribute("typeAgent") TypeAgent typeAgent){
        typeAgentService.save(typeAgent);
        return "redirect:/typeAgent";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////MOTIF VOYAGE///////////////////////////////////////////////////////////////

    @RequestMapping("/motifVoyage")
    public String viewPageMotifVoyage(Model model){
        List<MotifVoyage> motifVoyageList = motifVoyageService.motifVoyageList();
        model.addAttribute("motifVoyageList",motifVoyageList );

        return "motifVoyage";
    }

    @RequestMapping("/newMotifVoyage")
    public String ShowNewMotifVoyageForm(Model model){
        MotifVoyage motifVoyage = new MotifVoyage();
        model.addAttribute("motifVoyage", motifVoyage);
        return "new_motifVoyage";
    }

    @RequestMapping(value = "/saveMotifVoyage", method = RequestMethod.POST)
    public String SaveTypeagent(@ModelAttribute("motifVoyage") MotifVoyage motifVoyage){
        motifVoyageService.save(motifVoyage);
        return "redirect:/motifVoyage";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////DESTINATION////////////////////////////////////////////////////////////////

    @RequestMapping("/destination")
    public String viewPageDestination(Model model){
        List<Destination> destinationList = destinationService.destinationList();
        model.addAttribute("destinationList",destinationList );

        return "destination";
    }

    @RequestMapping("/newDestination")
    public String ShowNewDestinationForm(Model model){
        Destination destination = new Destination();
        model.addAttribute("destination", destination);
        return "new_destination";
    }

    @RequestMapping(value = "/saveDestination", method = RequestMethod.POST)
    public String SaveDestination(@ModelAttribute("destination") Destination destination){
        destinationService.save(destination);
        return "redirect:/destination";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////AGENT/////////////////////////////////////////////////////////////////////

    @RequestMapping("/agent")
    public String viewPageAgent(Model model){
        List<Agent> agentList = agentService.agentList();
        model.addAttribute("agentList",agentList );

        return "agent";
    }

    @RequestMapping("/newAgent")
    public String ShowNewAgentForm(Model model){
        Agent agent = new Agent();
        List<TypeAgent> typeAgentList = typeAgentService.TypeAgentList();
        model.addAttribute("typeAgentList",typeAgentList );
        model.addAttribute("agent", agent);
        return "new_agent";
    }

    @RequestMapping(value = "/saveAgent", method = RequestMethod.POST)
    public String SaveAgent(@ModelAttribute("agent") Agent agent){
        agentService.save(agent);
        return "redirect:/agent";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////PROCEDURE//////////////////////////////////////////////////////////////////

    @RequestMapping("/procedure")
    public String viewPageProcedure(Model model){
        List<Procedur> procedureList = procedureService.ProcedureList();
        model.addAttribute("procedureList",procedureList );

        return "procedure";
    }

    @RequestMapping("/newProcedure")
    public String ShowNewProcedureForm(Model model){
        Procedur procedure = new Procedur();
        model.addAttribute("procedure", procedure);
        return "new_procedure";
    }

    @RequestMapping(value = "/saveProceduree", method = RequestMethod.POST)
    public String SaveProceduree(@ModelAttribute("procedure") Procedur procedur){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        Date date = new Date();
        procedur.setDateOuverture(date);
        procedur.setEtatProcedur("Debut");

        procedureService.save(procedur);
        return "redirect:/procedure";
    }

    @RequestMapping("/nouvelle_procedure/{idClient}")
    public ModelAndView SaveProcedure(@PathVariable(name = "idClient") String idClient){
        ModelAndView modelAndView = new ModelAndView("new_procedure");
        Procedur procedure = new Procedur();
        Long id = Long.valueOf(idClient);
        Client client = new Client();

        client = clientService.getClient(id);
        procedure.setClient(client);


        List<MotifVoyage> motifVoyageProcedureList = motifVoyageService.motifVoyageList();
        List<Agent> agentProcedureList = agentService.agentList();
        List<Destination> destinationProcedureList = destinationService.destinationList();


        modelAndView.addObject("destinationProcedureList", destinationProcedureList );
        modelAndView.addObject("motifVoyageProcedureList", motifVoyageProcedureList );
        modelAndView.addObject("agentProcedureList", agentProcedureList );
        modelAndView.addObject("procedure",procedure);


        return modelAndView;
    }
    @RequestMapping("/liste_procedure/{idClient}")
    public String ListeProcedure(@PathVariable(name = "idClient") Long idClient, Model model){

        //Long id = Long.valueOf(idClient);
        Client client = new Client();
        client = clientService.getClient(idClient);
        List<Procedur> procedurList = procedureService.ProcedureListClientC(client);
        model.addAttribute("procedurList", procedurList );
        model.addAttribute("client",client);

        return "liste_procedure";

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////OBSERVATION//////////////////////////////////////////////

    @RequestMapping("/liste_observation/{idProcedure}")
    public String ListeObservation(@PathVariable(name = "idProcedure") Long idProcedure, Model model){

        Procedur procedur = new Procedur();
        Client client = new Client();
        procedur = procedureService.getProcedure(idProcedure);
        List<Observation> ObservationList = observationService.ObservationListProcedur(procedur);
        client = procedur.getClient();

        model.addAttribute("ObservationList", ObservationList );
        model.addAttribute("client",client);

        return "liste_observation";

    }

    @RequestMapping("/new_observation/{idProcedur}")
    public ModelAndView NewObservation(@PathVariable(name = "idProcedur") String idProcedur){
        ModelAndView modelAndView = new ModelAndView("new_observation");
        Observation observation = new Observation();
        Procedur procedure = new Procedur();
        Long id = Long.valueOf(idProcedur);

        procedure = procedureService.getProcedure(id);
        observation.setProcedure(procedure);

        List<Agent> agentProcedureList = agentService.agentList();

        modelAndView.addObject("agentProcedureList", agentProcedureList );
        modelAndView.addObject("observation",observation);

        return modelAndView;
    }

    @RequestMapping(value = "/saveObservation", method = RequestMethod.POST)
    public String SaveObservation(@ModelAttribute("observation") Observation observation){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        Date date = new Date();
        observation.setDateObservation(date);
        Procedur procedure = new Procedur();

        procedure = observation.getProcedur();

        observationService.save(observation);
        return "redirect:/liste_observation/{procedure.idProcedur}";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
