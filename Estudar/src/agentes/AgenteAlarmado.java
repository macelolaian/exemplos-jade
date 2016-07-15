/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author macelo
 */
public class AgenteAlarmado extends Agent{
    
    @Override
    protected void setup(){
        
        Object[] args = getArguments();        
        
        addBehaviour(new InformaIncendio());
    }
    
    private class InformaIncendio extends OneShotBehaviour{

        @Override
        public void action() {
            System.out.println("Avisando sobre um possível incendio!");
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("Bombeiro", AID.ISLOCALNAME));
            msg.setLanguage("Português");
            msg.setOntology("Emergência");
            msg.setContent("Fogo");
            myAgent.send(msg);
        }        
    }    
}
