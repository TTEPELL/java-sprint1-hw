
public class Converter  {
       double k=0.00075;
       double stepToKm(int summStep){
              return summStep*k;
       };
       double stepToKcalories(int summStep){
              return summStep*0.05 ;
       };
}



