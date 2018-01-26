/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;
import java.io.*;

/**
 *
 * 
 * @author (SRINJOY SANTRA) 
 * @version (WED 4 MARCH)
 */

public class Game_playk
{
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    String discard,drawcard;
    String gamers [][];
    int cardpresent [];
    String name [];
    int playerdata;
    int cardfunc[];
    
    Game_playk(int hp,int co,Playcards playcards)throws IOException
    {
       
        playerdata=hp+co;
        gamers =new String[playerdata][50];
        cardpresent=new int[playerdata];
        for(int i=0;i<playerdata;i++)//to initialize each gamer with 7 cards
            cardpresent [i]=7;
        name=new String[playerdata];
        for(int i=0;i<hp;i++)//to initialize each gamer with a name
        {
            System.out.println("Enter your name player "+(i+1));
            name [i]=br.readLine();
        } 
        System.out.println("\nto continue press C");
        String s=br.readLine();
        if(s.charAt(0)=='C')
            System.out.println("\f");
        for(int i=hp;i<playerdata;i++)//to initialize each computr player with a name
        {
            name [i]="autobot"+i;
        } 

        
        cardfunc=new int[playerdata];
        for(int i=0;i<playerdata;i++)//to initialize each gamer's without skip or reverse 
            cardfunc [i]=0;
        
        
        for(int i=0;i<playerdata;i++)// to initialize each gamer with randomly selected cards
        {

            for(int j=0;j<cardpresent[i];j++)
            {
                gamers [i][j]=playcards.cardselect();
            }
        }
         
    }
    public static void main()throws IOException
    {
        System.out.println("\f|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("|                                                                                  |");
        System.out.println("|                       WELCOME TO UNO                                             |");
        System.out.println("|                                                                                  |");
        System.out.println("|                                                                 (VERSION 99.9.99)|");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //Game_playk g=new Game_playk();
        while(1>0)
        {
            System.out.println("Enter 1 for new game");
            System.out.println("Enter 2 for exit");
            System.out.print("Enter your choice : ");

            int ch=Integer.parseInt(br.readLine());
            switch(ch)
            {   
                case 1  :players();
                break;
                case 2  :System.out.println("End of the program........");
                System.exit(0);
                break;
            }
        }
    }

    Game_playk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void players()throws IOException
    {
        System.out.println("\f\nSelect the type of the game:");
        System.out.println("Press 1 for player vs player");
        System.out.println("Press 2 for player vs computer");
        System.out.println("Press 3 for classic mode (1player vs 3computers)");
        int opt=Integer.parseInt(br.readLine()),hp=0,co=0;
        switch (opt)
        {
            case 1: System.out.println("Enter number of human players:");
                    hp=Integer.parseInt(br.readLine());co=0;
            break;
            case 2: System.out.println("Enter number of human players :");
                    hp=Integer.parseInt(br.readLine());
                    System.out.println("Enter number of computer players :");
                    co=Integer.parseInt(br.readLine());
            break;
            case 3: hp=1;co=3;
            break;
            default:System.out.println("Invalid Input!");
        }
        Playcards obj=new Playcards();
        Game_playk ob=new Game_playk(hp,co,obj);

        /*/int playerdata=;

        //String gamers [][]=new String[playerdata][50];
        //int cardpresent []=new int[playerdata];
        //for(int i=0;i<playerdata;i++)//to initialize each gamer with 7 cards
            //cardpresent [i]=7;
        String name []=new String[playerdata];
        for(int i=0;i<hp;i++)//to initialize each gamer with a name
        {
            System.out.println("Enter your name player "+(i+1));
            name [i]=br.readLine();
        } 
        System.out.println("\nto continue press C");
        String s=br.readLine();
        if(s.charAt(0)=='C')
            System.out.println("\f");
        for(int i=hp;i<playerdata;i++)//to initialize each computr player with a name
        {
            name [i]="autobot"+i;
        } 

        int cardfunc []=new int[playerdata];
        for(int i=0;i<playerdata;i++)//to initialize each gamer's without skip or reverse 
            cardfunc [i]=0;*/
        

        
        
        //REMOVING ANY SPECIAL CARD AS GAME CAN'T BEGIN WITH IT
        while(1>0)
        {
            ob.discard=obj.cardselect().trim();
            int pos=ob.discard.indexOf(' ');
            try
            {
                if(ob.discard.equals("WILD_DRAW_FOUR")||ob.discard.substring(0,pos).equals("WILD"))
                    continue;

                if(1>0) ob.cardfunc[0]=0;
                if(ob.discard.substring(0,pos).equals("DRAW_TWO"))
                    {
                        ob.cardfunc[0]=1;
                        ob.drawTwo(0,obj);
                    }

                if(ob.discard.substring(0,pos).equals("REVERSE"))
                    {
                        ob.cardfunc[0]=2;
                    }
                if(ob.discard.substring(0,pos).equals("SKIP"))
                    ob.cardfunc[0]=3;

                obj.display(ob.discard);
                
                break;
            }
            catch(Exception e)
            {}

        }
       

        ob.gamerep(hp);
    }

    public void gamerep(int hp)throws IOException
    { 
        // Playcards obj=new Playcards();
        int position;    
        int begin=1;

        int limit;            

        boolean rev,tmp,flag=true;
        if (cardfunc[0]==2) rev=false;
        else rev=true;
        int i=0,j=-9;
        String s;
        inwh:
        while(begin>0)//to repeat the game till 1 player wins
        {
            inif:
            if(rev) 
            {
                flag=true;
                System.out.println("\nchanged to ascending");

                limit=gamers.length;
                if(j!=-9) i=j;
                else i=0;

                inf1:
                for(;i<limit;i++)
                {
                    if(flag)
                    {

                        try
                        {        
                            if(cardpresent[i]==0)
                            {
                                System.out.println("@1NF1");
                                continue inf1;
                            }
                        }
                        catch(Exception e){;}

                        if(i<hp)rev=shortcut(rev,i);
                        else if(i<cardfunc.length) rev=autocomp(rev,i);
                        cardfunc[i]=0;
                        if(i==limit-1)j=-9;
                        if(rev==false)
                        {
                            System.out.println("changed back to descending");

                            if(i+1==limit) position=0;//
                            else position=i+1;
                            if (cardfunc.length!=2)
                                if(i<hp)tmp=shortcut(rev,position);
                                else if(i<cardfunc.length) tmp=autocomp(rev,i);
                            if(i-1<0) j=name.length-1;//
                            else j=i-1;

                            flag=false;
                        }
                    }
                     System.out.println("\f");
                } 
            }
            else
            {
                flag=true;

                System.out.println("\nchanged to descending");
                limit=0;
                if(j!=-9) i=j;
                else i=name.length-1;

                inf2:
                for(;i>limit;i--)
                {
                    if(flag)
                    {

                        try
                        {        
                            if(cardpresent[i]==0)
                            {
                                System.out.println("@1NF2");
                                continue;
                            }
                        }
                        catch(Exception e){}

                        if(i<hp)rev=shortcut(rev,i);
                        else if(i<cardfunc.length) rev=autocomp(rev,i);
                        cardfunc[i]=0;
                        if(i==0)j=-9;
                        if(rev==true)
                        {
                            System.out.println("changed back to ascending");

                            if(i-1==-1) position=gamers.length-1;//
                            else position=i-1;
                            if (cardfunc.length!=2)
                                if(i<hp)tmp=shortcut(rev,position);
                                else if(i<cardfunc.length) tmp=autocomp(rev,i);
                            if(i+1>name.length) j=0;//
                            else j=i+1;
                            flag=false;
                            //break inf2;
                        }
                    }
                     System.out.println("\f");
                }

            }

            begin++;
        }
    }

    public  boolean shortcut(boolean rev,int i)throws IOException
    {
        Playcards obj=new Playcards();

        boolean drawx=true;//to count wheteher a player has already drawn 1 card
        System.out.println("Hi, player "+(name[i]+" "+i));  

        if(cardfunc[i]==1)
        {
            System.out.println("Sorry your turn is skipped!");
            System.out.println(" You have got a draw two card!");
            obj.display(gamers,cardpresent,i);
            return rev;
        }
        else if(cardfunc[i]==2)
        {

            System.out.println("Sorry the direction of play is reversed!");
            System.out.println("\nto continue press C");
            String s=br.readLine();
             if(s.charAt(0)=='C')
              System.out.println("\f");
            return rev;
        }
        else if(cardfunc[i]==3)
        {
            System.out.println("Sorry your turn is skipped!");
            obj.display(gamers,cardpresent,i);
            return rev;
        }
        else if(cardfunc[i]==5)
        {
            System.out.println("Sorry your turn is skipped!");
            System.out.println(" You have got a draw four card!");
            obj.display(gamers,cardpresent,i);
            return rev;
        }
        else //if((cardfunc[i]==0)||(cardfunc[i]==4))
        {   inner :
            while(1>0)//to repeat the same iteraration to allow player to play a matching card
            {
                //String discard=this.discard;
                //  try
                // {
                obj.display(this.discard);
                System.out.println("To see your cards press Y.");
                System.out.println("To exit the game press E.");
                String s=br.readLine();
                if(s.charAt(0)=='Y')
                    obj.display(gamers,cardpresent,i);
                else     if(s.charAt(0)=='C')
                    cheatcode(gamers,cardpresent,i,this);
                else if(s.charAt(0)=='E')
                {
                    System.out.println("End of the present game.......");
                    main();
                }

                System.out.println("Please see your cards carefully.");
                System.out.println("To select any card press S");
                if (drawx)
                    System.out.println("To draw any card press D");
                else
                    System.out.println("To pass press P");
                s=br.readLine();
                if(s.charAt(0)=='S')
                {
                    System.out.println("Which card do you want to select between 1 to "+(cardpresent [i])+"?");
                    int option=Integer.parseInt(br.readLine())-1;

                    if (obj.checkcom(gamers[i][option],this.discard))//CHECKING MUST BE MORE ACURATE
                    {
                        this.discard=gamers[i][option];

                        int playerpos;
                        int u=obj.spclcard(this.discard);//IMPLEMENTATION OF SPECIAL CARDS NEED TO BE DONE
                        if (rev)
                        {
                            if(i+1==gamers.length) playerpos=0;//
                            else playerpos=i+1;
                        }
                        else
                        {
                            if(i-1==0) playerpos=gamers.length-1;//
                            else playerpos=i-1;//
                        }
                        //
                        cardfunc[playerpos]=u;   
                        switch (u)
                        {
                            case 1:drawTwo(playerpos,obj);
                            break;
                            case 2:if (rev==false) rev=true;
                            else if(rev==true) rev=false;
                            break;
                            case 4:wilD();
                            break;
                            case 5:drawFour(cardpresent,playerpos,gamers,obj);
                            wilD();
                            break;
                            default : break;

                        }
                        obj.exSelSort(gamers,this.discard,cardfunc,cardpresent,i);
                        cardpresent[i]--;
                        if(cardpresent[i]==1)
                        {
                            System.out.println("!");
                            String c=br.readLine();
                            if(c.equals("UNO"));
                            else
                            {
                                System.out.println("\nYou didnt say 'UNO' so you have to draw two cards!");
                                drawTwo(playerpos,obj);
                            }
                        }
                        if(cardpresent[i]==0)
                        {
                            System.out.println("you won");
                            obj.score(name[i],gamers,cardpresent,i);

                        }
                        return rev;

                    }
                    else 
                    {
                        System.out.println("Unmatched card");
                        //continue inner;
                    }
                }
                else if((s.charAt(0)=='D')&&(drawx))
                {
                    cardpresent[i]++;
                    drawx=false;
                    int flag=0;
                    while(flag==0)
                    {
                        this.drawcard=obj.cardselect();
                        if( this.drawcard.equals("null"))
                            flag=0;
                        else  
                        {
                            flag=1;

                        }

                    }
                    gamers[i][cardpresent[i]-1]=this.drawcard;
                }
                else if(s.charAt(0)=='P')
                {
                    return rev;
                }
                //}
                //catch(IndexOutOfBoundsException e) 
                //  {
                //    System.out.println("Exception occured");
                //System.err();
                //   continue;
                // }
            }

        }
        //return rev;
    }

    public  boolean autocomp(boolean rev,int i)throws IOException
    {
        boolean drawx=true;//to count wheteher a player has already drawn 1 card
        System.out.println("Player "+(name[i]+" "+i)+"making its decision");  
        for(int t=0;t<10000;t++)
        {
            if(t%100==0)
                System.out.print(" ");
            if(t%1000==0)
                System.out.print("#");
        }

        Playcards obj=new Playcards();
        if(cardfunc[i]==1)
        {
            System.out.println("\n"+name[i]+" turn was skipped!");
            System.out.println(" You have got a draw two card!");
           // obj.display(gamers,cardpresent,i);
            return rev;
        }
        else if(cardfunc[i]==2)
        {

            System.out.println("\n the direction of play is reversed!");
            System.out.println("\nto continue press C");
            String s=br.readLine();obj.display(gamers,cardpresent,i);
            // if(s.charAt(0)=='C')
            //    System.out.println("\f");
            return rev;
        }
        else if(cardfunc[i]==3)
        {
            System.out.println("\nSorry your turn was skipped!");
           // obj.display(gamers,cardpresent,i);
            return rev;
        }
        else if(cardfunc[i]==5)
        {
            System.out.println("\nSorry your turn is skipped!");
            System.out.println("\n"+name[i]+" You have got a draw four card!");
           // obj.display(gamers,cardpresent,i);
            return rev;
        }
        else 
        {   inner :
            while(1>0)//to repeat the same iteraration to allow player to play a matching card
            {

                //try
                //{
                obj.display(this.discard);
                //obj.display(gamers,cardpresent,i);//to be deleted
                System.out.println(name[i]+" holds "+cardpresent[i]+" cards");
               // String s=br.readLine();
               // if(s.charAt(0)=='C')
               //     cheatcode(gamers,cardpresent,i,ob);
                int combination[]=new int[cardpresent[i]];//selecting a card FROM VALID OPTIONS
                int y=0;
                for(int x=0;x<cardpresent[i];x++)
                {
                    if (obj.checkcom(gamers[i][x],this.discard))   
                    {
                        combination[y]=x;
                        y++;
                    }
                }
                if((y==0)&&(drawx))//drawing
                {
                    cardpresent[i]++;
                    drawx=false;
                    int flag=0;
                    while(flag==0)
                    {
                        this.drawcard=obj.cardselect();
                        if( this.drawcard.equals("null"))
                            flag=0;
                        else  
                        {
                            flag=1;

                        }

                    }
                    gamers[i][cardpresent[i]-1]=this.drawcard;

                    System.out.println(name[i]+" has drawn a card.");
                }
                else if(drawx==false)//passing
                { 
                    System.out.println(name[i]+" has passed.");
                    return rev;
                }
                else
                {
                    int n=obj.random(y);//n=storing the random postion
                    int o=combination[n];//o=storing the position from combination[]
                    if(obj.checkcom(gamers[i][o],this.discard)) //checking again wheder the chosen card is valid or not
                        this.discard=gamers[i][o];

                    int playerpos;

                    if (rev)
                    {
                        if(i+1==gamers.length) playerpos=0;//
                        else playerpos=i+1;
                    }
                    else
                    {
                        if(i==0) playerpos=gamers.length-1;//
                        else playerpos=i-1;//
                    }
                    int u=obj.spclcard(this.discard);//IMPLEMENTATION OF SPECIAL CARDS NEED TO BE DONE
                    //for(int t=0;t<1000;t++);
                    cardfunc[playerpos]=u;   
                    switch (u)
                    {
                        case 1:drawTwo(playerpos,obj);
                        break;
                        case 2:if (rev==false) rev=true;
                        else if(rev==true) rev=false;
                        break;

                        case 4:
                        wilD(0);
                        break;
                        case 5:drawFour(cardpresent,playerpos,gamers,obj);
                        wilD(0);
                        break;
                        default : break;

                    }
                    System.out.println(name[i]+" has played a card");
                    System.out.println(this.discard);//to be deleted
                    obj.exSelSort(gamers,this.discard,cardfunc,cardpresent,i);
                    cardpresent[i]--;
                    System.out.println(name[i]+"holds "+cardpresent[i]+" cards");
                    if(cardpresent[i]==1)
                    {
                        int c=(int)Math.round(Math.random()*1);
                        System.out.println("!");
                        if(c==0)
                        {
                            //System.out.println("\nYou didnt say 'UNO' so you have to draw two cards!");
                            drawTwo(playerpos,obj);
                        }
                    }
                    if(cardpresent[i]==0)
                    {
                        System.out.println(name[i]+" has won");
                        obj.score(name[i],gamers,cardpresent,i);

                    }
                    return rev;
                }

            }
            /*   catch(Exception e) 
            {
            System.out.println("Exception occured");
            //System.err();
            continue;
            }
            }*/

        }
    }

    public void exSelSort(String gamers[][],String discard,int cardfunc[],int cardpresent [],int playerpos)
    { 

        boolean flag=false;
        for(int i=0;i<cardpresent[playerpos];i++)
        {

            if(gamers[playerpos][i].equals(discard))
                flag=true;
            if(flag==true)
                gamers[playerpos][i]=gamers[playerpos][i+1];
        }
    }

    public void cheatcode(String g[][],int cp[],int i,Game_playk ob)throws IOException
    {
        System.out.println("enter the cards");
        for(int j=0;j<cp[i];j++)
        {
            String user=br.readLine();
            if(user.charAt(0)==' ')break;
            else 

                g[i][j]=user;

        }
    }

    private void drawTwo(int playerpos,Playcards obj)
    {
        int count=0;
        while(count<2)
        {
            cardpresent[playerpos]++;//
            gamers[playerpos][cardpresent[playerpos]-1]=obj.cardselect();//DRAW TWO 
            count++;
        }
    }

    private void drawFour(int cardpresent[],int playerpos,String gamers[][],Playcards obj)throws IOException
    {
        int count=0;
        while(count<4)               //wd4
        {
            cardpresent[playerpos]++;
            gamers[playerpos][cardpresent[playerpos]-1]=obj.cardselect();//DRAW fOUR

            count++;

        }

    }

    void wilD()throws IOException
    {
        System.out.println("enter the colour:");
        String colopt=" "+br.readLine();
        this.discard+=colopt;
    }

    void wilD(int x)throws IOException
    {
        Playcards obj=new Playcards();
        int n=obj.random(3);
        String col="";
        switch (n)
        {

            case 0 : col =" BLUE" ; break;
            case 1 :  col =" GREEN" ; break;
            case 2 :  col =" RED" ; break;
            case 3 :  col =" YELLOW" ; break;

        }
        this.discard+=col;
    }
}
