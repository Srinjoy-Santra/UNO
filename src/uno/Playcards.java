/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author nEW u
 */

public class Playcards
{
    public String cardselect() // 
    { /*to randomly give a card */
        String card="";
        int number=random(14);

        switch(number)
        {
            case 0 : 
            case 1 : 
            case 2 : 
            case 3 : 
            case 4 : 
            case 5 : 
            case 6 : 
            case 7 : 
            case 8 : 
            case 9 : 
                card =Integer.toString(number);
            break;   
            case 10 : card = "DRAW_TWO";       break;   
            case 11 : card = "REVERSE";       break;
            case 12 : card = "SKIP";       break;
            case 13 : card = "WILD";       break;
            case 14 : card = "WILD_DRAW_FOUR";       break;
        }
        if((number!=13)&&(number!=14))
        {      int colour=random(3);
            switch(colour)
            {
                case 0 : card =card+" BLUE" ; break;
                case 1 :  card =card+" GREEN" ; break;
                case 2 :  card =card+" RED" ; break;
                case 3 :  card =card+" YELLOW" ; break;

            }
        }
        return card;
    }

    public int random(int n)
    {
        return (int)Math.round(Math.random()*n);
    }

    public String split(String g,int opt)
    {
        String cardval=g+" ";//cardval--> info stored in each card
        String num="";//num--> to store the number part
        String col="";//col--> to store the colour part
        String w="";
        int count=0;

        for(int x=0;x<cardval.length();x++)
        {
            if (cardval.charAt(x)==' ')
            {
                if ((count==0)/*&&(w.length()==1)*/)num=w;
                else col=w;
                count++;
                w="";
            }
            else
            {
                w=w+cardval.charAt(x);
            }
        }
        if(opt==1)
        return num;
        else
        return col;
    }
    
    public    boolean checkcom(String g,String d)
    {
        if(split(g,1).equals(split(d,1)))
        {
            return true;
        }
        else if(split(g,2).equals(split(d,2)))
        {
            return true;
        }
        else if((split(g,1).equals("WILD"))||(split(g,1).equals("WILD_DRAW_FOUR")))
        return true;
        else return false;
        
    }

    public void display(String g[][],int cp[],int i)
    {
        for(int j=0;j<cp[i];j++)
        {
            String cardval=g[i][j]+" ";//cardval--> info stored in each card
            System.out.println(" "+(j+1)+"."+cardval);
        }
    }

    
    public void display(String g)
    {
        String num=split(g,1);
        String col=split(g,2);
        System.out.println("\nDISCARD PILE:");
        System.out.println("------------------");
        System.out.println("|                |");
        System.out.print("|"+(num));
        for(int z=0;z<14-num.length();z++)
            System.out.print(" ");
        System.out.println("  |");
        System.out.print("|"+(col));
        for(int y=0;y<12-col.length();y++)
            System.out.print(" ");
        System.out.println("    |");
        System.out.println("|                |");
        System.out.println("------------------");
    }

    public boolean cardlimit(String carray[][],String s,int size,int pos )
    {
        for(int i=0;i<size;i++)
        {
            if(carray[pos][i].equals(s)) return false;
        }
        return true;
    }

    public int spclcard(String scard)
    {
        scard+=" ";
        int p=scard.indexOf(' ');
        if(scard.substring(0,p).equals("DRAW_TWO")) return 1;
        else if(scard.substring(0,p).equals("REVERSE")) return 2;
        else if(scard.substring(0,p).equals("SKIP"))return 3;
        else if(scard.substring(0,p).equals("WILD"))return 4;
        else if(scard.substring(0,p).equals("WILD_DRAW_FOUR") ) return 5;
        else return 0;
    }

    public void score(String name,String g[][],int cp[],int posi)
    {
        int total=0;
        int c;
        for(int a=0;a<g.length;a++)
        {
            if(a!=posi)
                {
                    for(int b=0;b<cp[a];b++)
                    {
                        c=spclcard(g[a][b]);
                        switch (c)
                        {
                            case 0:total+=(int)g[a][b].charAt(0);
                            break;
                            case 1:total+=20;
                            break;
                            case 2:total+=20;
                            break;
                            case 3:total+=20;
                            break;
                            case 4:total+=50;
                            break;
                            case 5:total+=50;
                        }
                    }
                }
            }
             System.out.println(name+"'s score= "+total);
        }
        
        public void exSelSort(String gamers[][],String discard,int cardfunc[],int cardpresent [],int playerpos)
        { 
        
        boolean flag=false;
        for(int i=0;i<cardpresent[playerpos];i++)
            {

            if(checkcom(gamers[playerpos][i].trim(),discard.trim()))
                flag=true;
            if(flag==true)
                gamers[playerpos][i]=gamers[playerpos][i+1];
            }
        }
    public void help()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                  |                                                                                                  |");
        System.out.println("|                  |                                                                                                  |");
        System.out.println("|                  |                                                                                                  |");
        System.out.println("|                  |                                                                                                  |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("|                                                                                                                     |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        
    }
    
    public void rules()
    {
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
      System.out.println("");  
    }
}

