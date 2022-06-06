//Modaser Abdelhamied Raafat
//20190507
//s1,s2
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;
import java.util.LinkedHashSet;
import java.lang.Math;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
class Index2 {
public int oc(Vector<String>pl,String x)
    {
        int r=0;
        for(int i=0;i<pl.size();i++)
        {
            if(x.equals(pl.get(i)))
            r++;
        }
        return r;
    }
Vector<String> OR(Vector<String> pL1, Vector<String> pL2) 
{
    Vector<String> answer = new Vector<String>();
    for(String j:pL1)
{
answer.add(j);
}
for(String i:pL2)
{
answer.add(i);
}
return answer;
}
public HashMap<String, Double>
    sortByValue(HashMap<String, Double> hm)
    {
        List<Map.Entry<String, Double> > list
            = new LinkedList<Map.Entry<String, Double> >(
                hm.entrySet());
 
        Collections.sort(
            list, (i2,i1) -> i1.getValue().compareTo(i2.getValue()));
 
        HashMap<String, Double> temp
            = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
public double j (String x,String y) throws IOException
   {
    Vector<String>b=new Vector<String>();
    try (BufferedReader file = new BufferedReader(new FileReader(y))) {
        String ln;
        while ((ln = file.readLine()) != null) {
            String[] words = ln.split("\\W+");
            for (String word : words) {
                word = word.toLowerCase();
                b.add(word);
            }
        } 
    }
        catch (IOException e) {
            System.out.println("File " + y + " not found. Skip it");
        }
    
Vector<String>a=new Vector<String>();
try (BufferedReader file = new BufferedReader(new FileReader(x))) {
    String ln;
    while ((ln = file.readLine()) != null) {
        String[] words = ln.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            a.add(word);
        }
    } 
}
    catch (IOException e) {
        System.out.println("File " + x + " not found. Skip it");
    }

Vector<String>z=OR(a, b);
Vector<Integer>D1=new Vector<Integer>();
Vector<Integer>D2=new Vector<Integer>();
LinkedHashSet<String> d = new LinkedHashSet<String>(z);
z.clear();
z.addAll(d);
 for(String q:z)
{
    if (a.contains(q))
    {
    int e=oc(a,q);
    D1.add(e);
    }
    else
    D1.add(0);
}
for(String w:z)
{
    if (b.contains(w))
{
    int g=oc(b,w);
    D2.add(g);
}    
else
    D2.add(0);
}
long sum1=0,sum2=0;
for(int s1:D1)
{
   sum1+=s1*s1;    
}
for(int s2:D2)
{
   sum2+=s2*s2;    
}
long sum3=0;
for(int i=0;i<z.size();i++)
{
sum3+=(D1.get(i)*D2.get(i));
}
double sim=(double)sum3/ (Math.sqrt((double)sum1)*Math.sqrt((double)sum2));
return sim;
   }
   HashMap<String ,Double> cosine(String[]str)throws IOException
   {
    HashMap<String ,Double>ma=new HashMap<String ,Double>();
       for(int i=0;i<str.length;i++)
      { for(int j=0;j<i;j++)
       {
        ma.put("D"+(j+1)+" and D"+(i+1) +" Cosine similarity = ",j((String)str[j],(String)str[i]));
       }
    }
    return ma;
   }
public static class InvertedIndex002 {
        public static void main(String args[]) throws IOException {
            Index2 index = new Index2();
            HashMap<String, Double> hm=  index.cosine(new String[]{
                "C:\\Users\\modaser\\Desktop\\New folder (6)\\m,m,\\docs\\702.txt",
                "C:\\Users\\modaser\\Desktop\\New folder (6)\\m,m,\\docs\\703.txt",
                "C:\\Users\\modaser\\Desktop\\New folder (6)\\m,m,\\docs\\704.txt",

            });
                         Map<String, Double> hm1 = index.sortByValue(hm);
                         hm1.forEach((key, value) -> System.out.println(key  + value)); 
                       
    }
}
   
    }