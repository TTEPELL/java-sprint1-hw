
public class Converter  {
       double coefficientStepToKm=0.00075;
       double stepToKm(int summStep){
              return summStep*coefficientStepToKm;
       };
       double stepToKcalories(int summStep){
              return summStep*0.05 ;
       };
}



