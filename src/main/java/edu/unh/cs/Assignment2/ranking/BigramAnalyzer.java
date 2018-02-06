// Bigram Language Model
package edu.unh.cs.Assignment2.ranking;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

/*
Using Analyzer which builds TokenStreams, which analyze text. 
It thus represents a policy for extracting index terms from text.*/

public class BigramAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new StandardTokenizer(); //tokenizer is being used to braek the string into token.
        ShingleFilter sf = new ShingleFilter(source, 2, 2); //it creates combinations of tokens as a single token.
        sf.setTokenSeparator(" ");
        TokenStream filter = new LowerCaseFilter(sf);
        return new TokenStreamComponents(source, filter);
    }

}

