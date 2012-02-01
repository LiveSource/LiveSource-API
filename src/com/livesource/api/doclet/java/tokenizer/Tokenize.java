package com.livesource.api.doclet.java.tokenizer;

import java.util.ArrayList;

public class Tokenize {

        public static ArrayList<String> getClassArrayIndex(String classSource) {

                ArrayList<String> tokenArray = new ArrayList<String>();

                new TokenizeComments(classSource, tokenArray);

                TokenizeClassDeclaration.getClassArrayIndex(tokenArray);

                return tokenArray;
        }
}