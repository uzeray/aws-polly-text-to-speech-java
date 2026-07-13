# AWS Polly Text-to-Speech (Java)

**Turn any text file into a narrated MP3 from the command line.** A small Java/Maven CLI that reads a text file and converts it to natural-sounding speech using [Amazon Polly](https://aws.amazon.com/polly/) — no manual AWS console work, just point it at a file and get audio out.

## How it works

1. `GrammarRules.extractTextFromFile` reads the input text file line by line.
2. `SpeechConfigurations` builds a `SynthesizeSpeechRequest` (text, voice, output format) and calls the Polly API.
3. `SaveAudioFile` writes the resulting audio stream to a timestamped `.mp3` file under `./output/`.

## Requirements

- Java 21, Maven
- An AWS account with Polly access
- AWS credentials available via the standard SDK provider chain — either:
  - environment variables `AWS_ACCESS_KEY_ID` / `AWS_SECRET_ACCESS_KEY` / `AWS_REGION`, or
  - a local profile in `~/.aws/credentials`

No credentials are stored in this repository.

## Usage

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.donoApp.Main" -Dexec.args="path/to/text-file.txt Filiz mp3"
```

Arguments: `<path-to-text-file> [voiceId] [outputFormat]` — `voiceId` defaults to `Filiz`, `outputFormat` defaults to `mp3`.

Output is written to `./output/<timestamp>.mp3`.

## Stack

Java 21 · Maven · AWS SDK for Java (Polly) · Jackson (CBOR)

## Author

Ünal Zeray
