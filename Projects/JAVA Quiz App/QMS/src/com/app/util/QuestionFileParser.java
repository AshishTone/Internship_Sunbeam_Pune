package com.app.util;

import com.app.model.*;
import java.io.*;
import java.util.*;
import com.app.model.Question;

public class QuestionFileParser {

    public static List<Question> parse(File file) throws Exception {
        List<Question> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line, q=null,a=null,b=null,c=null,d=null;
        char ans=0;

        while((line=br.readLine())!=null){
            line=line.trim();
            if(line.isEmpty()){
                if(q!=null){
                    list.add(new Question(0,0,q,a,b,c,d,ans));
                }
                q=a=b=c=d=null; ans=0;
                continue;
            }
            if(q==null) q=line;
            else if(line.matches("[A-D][).].*")){
                char ch=line.charAt(0);
                String val=line.substring(2).trim();
                if(ch=='A')a=val;
                if(ch=='B')b=val;
                if(ch=='C')c=val;
                if(ch=='D')d=val;
            }
            else if(line.startsWith("ANSWER:")){
                ans=line.charAt(7);
            }
        }
        br.close();
        return list;
    }
    
}
