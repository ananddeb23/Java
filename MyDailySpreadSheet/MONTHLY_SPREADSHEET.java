import java.io.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
class MONTHLY_SPREADSHEET
{

    public static void main(String args[])throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //get current date time with Date()
        Date date = new Date();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" MY Monthly SPREADSHEET Statement ");
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
        System.out.println("PRESS ENTER");
        br.readLine();
        System.out.println("\f");
        System.out.println("\n"+"Enter Name Of the Month");
        String mnth=br.readLine();
        System.out.println("\f"+"Miscellaneous");
        FileReader fr=new FileReader("missmain"+".txt");
        BufferedReader fbr=new BufferedReader(fr);
        String a="";
        double totmis=0,totcl=0;

        while((a=fbr.readLine())!=null)
        {

            StringTokenizer st =new StringTokenizer(a,"\t");
            int d=st.countTokens();
            String ar[]=new String[d];
            for(int x=0;x<d;x++)
            {
                ar[x]=st.nextToken();
            }
            double tr=Double.parseDouble(ar[1]);
            totmis=totmis+tr;

        }
        System.out.println("\n"+"Monthly Expenditure on Miscellaneous Items is : "+totmis);
        FileWriter fw2=new FileWriter("missmainm"+".txt",true);
        BufferedWriter bw2=new BufferedWriter(fw2);

        String yu=dateFormat.format(date);

        PrintWriter pw2=new PrintWriter(bw2);
        pw2.println(mnth+"\t"+(totmis));
        pw2.close();bw2.close();fw2.close();
        System.out.println("\n"+"Press Enter to Proceed");
        br.readLine();
        fr=new FileReader("mobcost"+".txt");
        fbr=new BufferedReader(fr);
        a="";

        while((a=fbr.readLine())!=null)
        {

            StringTokenizer st =new StringTokenizer(a,"\t");
            int d=st.countTokens();
            String ar[]=new String[d];
            for(int x=0;x<d;x++)
            {
                ar[x]=st.nextToken();
            }
            double tr=Double.parseDouble(ar[1]);
            totcl=totcl+tr;

        }
        System.out.println("\n"+"Monthly Expenditure on Cellphone is : "+totcl);
        FileWriter fw3=new FileWriter("mobcostm"+".txt",true);
        BufferedWriter bw3=new BufferedWriter(fw3);

        yu=dateFormat.format(date);

        PrintWriter pw3=new PrintWriter(bw3);
        pw3.println(mnth+"\t"+(totcl));
        pw3.close();bw3.close();fw3.close();
        System.out.println("\n"+"Press Enter to Proceed");
        br.readLine();

        fbr.close();fr.close();
        System.out.println("\f"+"Nett Expenditure oF This Month is : "+(totcl+totmis));
        FileWriter fw1=new FileWriter("MonthCost"+".txt",true);
        BufferedWriter bw1=new BufferedWriter(fw1);

         yu=dateFormat.format(date);

        PrintWriter pw1=new PrintWriter(bw1);
        pw1.println(mnth+"\t"+yu+"\t"+(totcl+totmis));
        pw1.close();bw1.close();fw1.close();

        System.out.println("Thank You");

    }
}

       