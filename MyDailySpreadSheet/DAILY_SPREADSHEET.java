import java.io.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
class DAILY_SPREADSHEET
{

    public static void main(String args[])throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //get current date time with Date()
        Date date = new Date();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=0;

        System.out.println(" MY DAILY SPREADSHEET MANAGEMENT SYSTEM");
        System.out.println("");
        System.out.println("You can view Detailed daily expenses sheet by locating 'SpreadSheet.txt' file in 'MyDocuments/MyDailySpreadsheet' ! ");
        System.out.println("You can view Dated daily cost sheet by locating 'CostSheet.txt' file in 'MyDocuments/MyDailySpreadsheet' ! ");
        System.out.println("You can view Dated daily Cellphone cost sheet by locating 'mobcost.txt' file in 'MyDocuments/MyDailySpreadsheet' ! ");
        System.out.println("You can view Dated daily Miscellaneous cost sheet by locating 'CostSheet.txt' file in 'MyDocuments/MyDailySpreadsheet' ! ");
        for(int x=0;x<5;x++)
        {
            try
            {
                Thread.sleep(1000);
                System.out.print("............");
            }
            catch (Exception e)
            {
            }
        }
        System.out.println();
        br.readLine();
        System.out.println("\f");

        System.out.println("\f"+"Miscellaneous");
        double mis=miss();
        System.out.println(" CELLPHONE BALANCE");
        double cl= cell();
        double nett=cl+mis;
        FileWriter fw1=new FileWriter("CostSheet"+".txt",true);
        BufferedWriter bw1=new BufferedWriter(fw1);

        String yu=dateFormat.format(date);

        PrintWriter pw1=new PrintWriter(bw1);
        pw1.println(yu+"\t"+nett);
        pw1.close();bw1.close();fw1.close();

        System.out.println("\f"+"Nett cost Today : "+nett);
        
        System.out.println("Thank You :) ");
    }

    public static double miss()throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //get current date time with Date()
        Date date = new Date();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String yu=dateFormat.format(date);
        FileWriter fw2=new FileWriter("SpreadSheet"+".txt",true);
        BufferedWriter bw2=new BufferedWriter(fw2);

        PrintWriter pw2=new PrintWriter(bw2);
        pw2.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        pw2.println();
        pw2.println();
        pw2.println(yu);
        pw2.println("____________________________________________________________________________________________");
        pw2.println();
        pw2.println();

        pw2.println("Miscellaneous Expenses");pw2.println();
        FileWriter fw=new FileWriter("missdaily"+".txt",true);
        BufferedWriter bw=new BufferedWriter(fw);

        PrintWriter pw=new PrintWriter(bw);
        String tr="";
        double tot=0;

        System.out.println("Remember To Enter '1' To Discontinue,Where You Enter The Item Name ");
        pw.println(yu);pw.println();
        do
        {

            if(!(tr.equals("1")))
            {
                System.out.println("Enter item name");
                String ite=br.readLine();
                if(!(ite.equals("1")))
                {
                System.out.println("Enter cost");
                double cst=Double.parseDouble(br.readLine());
                String fin=ite+"\t"+cst;

                pw.println(fin);
                pw2.println(fin);
                tot=tot+cst;
            }
                
                tr=ite;

            }

        }while(!(tr.equals("1")));
        pw.println("\n"+"Total cost today "+tot);
        pw.println();
        pw.println(".............................");
        System.out.println("System now takes you to the main screen");
        pw.close();bw.close();fw.close();
        FileWriter fw1=new FileWriter("missmain"+".txt",true);
        BufferedWriter bw1=new BufferedWriter(fw1);

        yu=dateFormat.format(date);

        PrintWriter pw1=new PrintWriter(bw1);
        pw1.println(yu+"\t"+tot);
        pw1.close();bw1.close();fw1.close();

        System.out.println("\f"+"Nett chart Of Misscelaneous Expenses ");
        dispMis();
        pw2.println();
        pw2.println(".....................................................");
        pw2.close();bw2.close();fw2.close();
        return tot;

    }

    public static void dispMis()throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        FileReader fr=new FileReader("missdaily"+".txt");
        BufferedReader fbr=new BufferedReader(fr);
        String a;
        System.out.println("\f"+"Displaying records of Miscellaneous Expenses");
        while((a=fbr.readLine())!=null)
        {

            System.out.println(a);

        }
         System.out.println("\n"+"Press Enter to Proceed");
        br.readLine();

        fbr.close();fr.close();

    }

    public static double cell()throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //get current date time with Date()
        Date date = new Date();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input Current Balance"); 

        double cb=Double.parseDouble(br.readLine());
        FileWriter fw2=new FileWriter("SpreadSheet"+".txt",true);
        BufferedWriter bw2=new BufferedWriter(fw2);

        PrintWriter pw2=new PrintWriter(bw2);
        FileReader fr=new FileReader("lastmobbal"+".txt");
        BufferedReader fbr=new BufferedReader(fr);
        String a;
        double eb=0;
        String pr="";
        int c=0;
        while((a=fbr.readLine())!=null)
        {
            eb=Double.parseDouble(a);
        }

        fbr.close();fr.close();
        double dif=eb-cb;

        FileWriter fw=new FileWriter("lastmobbal"+".txt");
        BufferedWriter bw=new BufferedWriter(fw);

        String yu=dateFormat.format(date);

        PrintWriter pw=new PrintWriter(bw);
        String tr="";

        pw.println(cb);
        pw.close();bw.close();fw.close();
        FileWriter fw1=new FileWriter("mobcost"+".txt",true);
        BufferedWriter bw1=new BufferedWriter(fw1);

        yu=dateFormat.format(date);

        PrintWriter pw1=new PrintWriter(bw1);
        pw1.println(yu+"\t"+dif);
        pw1.close();bw1.close();fw1.close();
        pw2.println("Cost on Cellphone today was : "+dif);
        pw2.println(".....................................................");
        pw2.println();pw2.println();
        pw2.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Cost on Cellphone today was : "+dif+"\n"+"Press Enter to Proceed");
        br.readLine();
        pw2.close();bw2.close();fw2.close();
        dispcellb();
        return dif;
    }

    public static void dispcellb()throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        FileReader fr=new FileReader("mobcost"+".txt");
        BufferedReader fbr=new BufferedReader(fr);
        String a;
        double sum=0;
        System.out.println("\f"+"Displaying Cell Records");
        while((a=fbr.readLine())!=null)
        {

            System.out.println(a);

        }
        System.out.println("\n"+"Press Enter to Proceed");
        br.readLine();
        fbr.close();fr.close();

    }

}

