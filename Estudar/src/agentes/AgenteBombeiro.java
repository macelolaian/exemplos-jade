
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteBombeiro extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new PlantaoFogo());
    }
    
    private class PlantaoFogo extends CyclicBehaviour{

        @Override
        public void action(){
            ACLMessage msg = myAgent.receive();
            if(msg != null){
                String content = msg.getContent();
                AID emissor = msg.getSender();
                if(content.equalsIgnoreCase("Fogo")){
                    System.out.println("O agente " + emissor + " informou um possivel incendio");
                    System.out.println("Vou tomar as providências!");
                }
            }else{
                block();
            }
        }        
    }
}
