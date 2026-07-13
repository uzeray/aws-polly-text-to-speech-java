package org.donoApp;

import org.donoApp.Processors.GrammarRules;
import org.donoApp.Processors.SpeechConfigurations;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Usage: java -jar DonoApp.jar <path-to-text-file> [voiceId] [outputFormat]");
            System.exit(1);
        }

        String textPath = args[0];
        String voiceId = args.length > 1 ? args[1] : "Filiz";
        String outputFormat = args.length > 2 ? args[2] : "mp3";

        String readText = GrammarRules.extractTextFromFile(textPath);
        new SpeechConfigurations(readText, voiceId, outputFormat);
    }
}