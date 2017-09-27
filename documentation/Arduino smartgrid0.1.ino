#include "SPI.h"                        // Biblioteca pro Shield Ethernet
#include "Ethernet.h"                   // Include da biblioteca do shield Ethernet
//Carrega as bibliotecas
#include "EmonLib.h" 

EnergyMonitor emon1;
 
//Tensao da rede eletrica
float rede = 220.0;
//Pino do sensor SCT
//int pino_sct = 1;

byte mac[] = { 0xA0, 0xCC, 0x12, 0x34, 0xFF, 0xCA };

int watts = 250;
int teste = 1;
String devid = "ard000001c000001";

EthernetClient client;
//char server[] = "smartgrid-web.herokuapp.com";
IPAddress server(192,168,1,100);

void setup(){
    Ethernet.begin(mac);
    Serial.begin(9600);
    //Pino, calibracao - Cur Const= Ratio/BurdenR. 1800/62 = 29. 
    emon1.current(1, 62); 
//    emon1.current(1, 60);
}

void loop(void){
  //Calcula a corrente  
  double Irms = emon1.calcIrms(1480);
  
    Serial.println("Obtendo IP");
    Serial.println(Ethernet.maintain());
    
    Serial.print("Ip obtido: ");
    Serial.print(Ethernet.localIP());
    Serial.println(" ");
  
    Serial.print("Conectando ao Servidor... ");
    Serial.println(" ");
 //LOCAL
    if(client.connect(server, 8080)){
 //online     if(client.connect(server, 80)){
        Serial.print("Conectado ao server: ");
        Serial.println(server); 
        //Mostra o valor da corrente
        Serial.print("Corrente : ");
        Serial.println(Irms); // Irms
//   
//        //Calcula e mostra o valor da potencia
        Serial.print(" Potencia : ");
        Serial.println((Irms*rede)/1000);
   }
 
    client.print("GET /api/setconsumo");
    client.print("?watts=");
    client.print((Irms*rede)/1000);
 //   client.print(watts);
    client.print("&devid=");
    client.print(devid);
    client.println(" HTTP/1.1");
    client.print("Host: ");
    client.println(server);
    client.println("Connection: close");
    client.println();
    client.stop();
    Serial.print("Connection: close ");
    
    delay (3000);
}

