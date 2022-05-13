import java.util.Scanner;

public class app
{
  public static void main(String []args)
  {
    
    int[] level = {100,200,300,400,500,600,700,800,
                   900,1000,1200,1500,1800,2200,2800,3500,
                   4300,5300,6500,7800,9400,11300,13500,16000,
                   19000,22500,26500,31500,37000,45000,45000,45000,
                   60000,60000,60000,80000,80000,80000,100000,0};      
    int[] slot ={2,2,3,4,5,6,6,7,7,8,8,9,9,9,10,10,10,11,11,11,
                 12,12,12,13,13,14,14,15,15,16,16,16,17,17,17,17,18,18,18,18};
    int option,currentLevel,desiredLevel,final_level_with_yeti,final_level_with_no_yeti;
    double boxcost,boxcount,totalWaru,boxcount_with_yeti,boxcount_with_no_yeti,exp_with_yeti,
        exp_with_no_yeti,excessExp_with_yeti,excessExp_with_no_yeti,currentExperience,desiredExperience,experience,btime;
    boolean Inplay = true;
    while(Inplay)
    {
      clearScreen();
      option=currentLevel=desiredLevel=final_level_with_yeti=final_level_with_no_yeti=0;
      
      experience=boxcount_with_yeti=boxcount_with_no_yeti=exp_with_yeti=
      exp_with_no_yeti=excessExp_with_yeti=excessExp_with_no_yeti=0;    
           
      currentExperience=desiredExperience=totalWaru=boxcost=boxcount=-1;
      btime=-1;
      Scanner UserInput = new Scanner(System.in);
      System.out.println("Choose option:");
      System.out.println("Option 1: Current Level + Waru");
      System.out.println("Option 2: Current Level + Desired Level");
      System.out.println("Option 3: Exp table");
      System.out.println("Option 4: Exit");
      System.out.println("*note: if incorrect input: prompt will be repeated*");
      System.out.println();
      while(option!=1 && option!=2 && option!=3&& option!=4)
      {
        System.out.print("Option Number: ");
        option = UserInput.nextInt();
        UserInput.nextLine(); // this line to consume '\n' character         
      }
      switch(option)
      {
        case 1:
               while(currentLevel<1 || currentLevel>40)
               {
                 System.out.print("Current Level: ");
                 currentLevel = UserInput.nextInt();
                 UserInput.nextLine(); // this line to consume '\n' character
               }
               while(currentExperience<0 || currentExperience>=level[currentLevel-1])
               {
                 System.out.print("Current EXP: ");
                 currentExperience = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               while(totalWaru<0)
               {
                 System.out.print("Current Waru: ");
                 totalWaru = UserInput.nextDouble();
                 UserInput.nextLine();
              }   
               while(boxcost<0)
               {
                 System.out.print("C Box Cost: ");
                 boxcost = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               while(btime<0)
               {
                 System.out.print("Time(s) taken per C box: ");
                 btime = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               boxcount = Math.ceil(totalWaru/boxcost);
               exp_with_yeti = boxcount*45;
               exp_with_no_yeti = boxcount*30;
               final_level_with_yeti = currentLevel;
               final_level_with_no_yeti = currentLevel;
               for(int i=currentLevel-1;i<39;i++)
               {
                 if(exp_with_yeti>=level[i])
                 {
                   exp_with_yeti-=level[i];
                   final_level_with_yeti++;
                 }
                 else
                 {
                   excessExp_with_yeti = exp_with_yeti;
                   if(final_level_with_yeti==40)
                   {
                     excessExp_with_yeti =0;
                   }
                   break;
                 }
               }
               for(int i=currentLevel-1;i<39;i++)
               {
                 if(exp_with_no_yeti>=level[i])
                 {
                   exp_with_no_yeti-=level[i];
                   final_level_with_no_yeti++;
                 }
                 else
                 {
                   excessExp_with_no_yeti = exp_with_no_yeti;
                   if(final_level_with_no_yeti==40)
                   {
                     excessExp_with_no_yeti =0;
                   }
                   break;
                 }
               }
               System.out.println();
               System.out.println(String.format("Total number of C Box used: %,d",boxcount));
               System.out.println(String.format("Final Level (with Yeti): %,d",final_level_with_yeti));
               System.out.println(String.format("Excess Exp (with Yeti): %,d",excessExp_with_yeti));
               System.out.println(String.format("Final Level (with no Yeti): %,d",final_level_with_no_yeti));
               System.out.println(String.format("Excess Exp (with no Yeti): %,d",excessExp_with_no_yeti));    
               System.out.print("Estimated time to finish(Est " +btime+"s per C box): ");
               timer(boxcount,btime);    
               System.out.println();
               break;
               
       case 2:
               while(currentLevel<1 || currentLevel>40)
               {
                 System.out.print("Current Level: ");
                 currentLevel = UserInput.nextInt();
                 UserInput.nextLine(); // this line to consume '\n' character
               }
               while(currentExperience<0 || currentExperience>=level[currentLevel-1])
               {
                 System.out.print("Current EXP: ");
                 currentExperience = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               while(desiredLevel<1 || desiredLevel>40 || desiredLevel< currentLevel)
               {
                 System.out.print("Desired Level: ");
                 desiredLevel = UserInput.nextInt();
                 UserInput.nextLine();
               }
               while(desiredExperience<0 || desiredExperience>level[desiredLevel-1])
               {
                 System.out.print("Desired EXP: ");
                 desiredExperience = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               while(boxcost<0)
               {
                System.out.print("C Box Cost: ");
                boxcost = UserInput.nextDouble();
                UserInput.nextLine();
               }
               while(btime<0)
               {
                 System.out.print("Time(s) taken per C box: ");
                 btime = UserInput.nextDouble();
                 UserInput.nextLine();
               }
               experience=0;
               for(int i=currentLevel-1;i<desiredLevel-1;i++)
               {
                 experience += level[i];
               }
               experience = experience - currentExperience + desiredExperience;
               boxcount_with_yeti =  Math.ceil(experience/45);
               boxcount_with_no_yeti =  Math.ceil(experience/30);
               System.out.println();
               System.out.println(String.format("Total Experience to gain: %,d",experience));
               
               System.out.println(String.format("Total number of C Box needed(with Yeti): %,d",boxcount_with_yeti)); //%,d for comma and number formmating
               System.out.println(String.format("Total amount of waru needed(with Yeti): %,d",boxcount_with_yeti*boxcost));
               System.out.print("Estimated time to finish(Est " +btime+"s per box): ");
               timer(boxcount_with_yeti,btime);
               System.out.println();
               
               System.out.println(String.format("Total number of C Box needed(with no Yeti): %,d",boxcount_with_no_yeti));
               System.out.println(String.format("Total amount of waru needed(with no Yeti): %,d",boxcount_with_no_yeti*boxcost));
               System.out.print("Estimated time to finish(Est " +btime+"s per C box): ");
               timer(boxcount_with_no_yeti,btime);
               System.out.println();
               break;
         case 3:
                while(btime<0)
                {
                  System.out.print("Time(s) taken per C box: ");
                  btime = UserInput.nextDouble();
                  UserInput.nextLine();
                }
                while(boxcost<0)
                {
                 System.out.print("C Box Cost: ");
                 boxcost = UserInput.nextDouble();
                 UserInput.nextLine();
                }
                System.out.println("Resize the command prompt to fullscreen to see full table properly");
                System.out.print("Farm Level\tFarm EXP to next level\tMonster Slots\t");
                System.out.print("Number of C box(with Yeti)\tNumber of C box(with no Yeti)\t");
                System.out.print("Time Taken(with Yeti)\tTime Taken(with no Yeti)\t");
                System.out.println("Total cost(with Yeti)\tTotal cost(with no Yeti)");
                
                for(int i=0;i<40;i++)
                {
                  System.out.print(String.format("%10d\t\t%14d\t\t%5d\t",(i+1),level[i],slot[i])); //10%d for padding to the right
                  System.out.print(String.format("%26.0f\t\t\t\t%5.0f\t", Math.ceil((double)level[i]/45.0), Math.ceil((double)level[i]/30))); 
                  timerformattable(level[i]/45,btime);
                  System.out.print("\t   ");
                  timerformattable(level[i]/30,btime);
                  System.out.print(String.format("\t\t%,13.0f\t\t%,16.0f",(level[i]/45)*boxcost,(level[i]/30)*boxcost));
                  System.out.println();
                }
                break;
         case 4:
                System.exit(0);
                
     } 
     System.out.print("Back to menu? y/n: ");
     String repeat = UserInput.nextLine();
     if (repeat == "n")
     {
       Inplay = false;
     }
    }      
  }
  public static void timer(double numBox,double boxtime) // tell user time left till program ends
  {
    double dtotal= numBox;
    double time = dtotal*boxtime; // 1 box 3.5s
    int hr = (int)time/3600;
    int min = (int)(time%3600)/60;
    int sec = (int)(time%3600)%60;
    System.out.print(String.format("%dhr %dmin %ds",hr,min,sec));
  }
  public static void timerformattable(double numBox,double boxtime) // tell user time left till program ends
  {
    double dtotal= numBox;
    double time = dtotal*boxtime; // 1 box 3.5s
    int hr = (int)time/3600;
    int min = (int)(time%3600)/60;
    int sec = (int)(time%3600)%60;
    System.out.print(String.format("%9dhr %2dmin %2ds",hr,min,sec));
  }
  public static void clearScreen() 
  {  
      try
      {
          new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      } 
      catch(Exception E)
      {
          System.out.println(E);
      }
  } 
}