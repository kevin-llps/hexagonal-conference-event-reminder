package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.TalkDto;

import java.time.LocalDateTime;
import java.util.List;

public class TalkDtoSample {

    public static List<TalkDto> talkDtoList() {
        SpeakerDto speakerKevLps = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        SpeakerDto speakerCharLcs = SpeakerDto.builder()
                .firstname("charlie")
                .lastname("lcs")
                .build();

        SpeakerDto speakerIzaElk = SpeakerDto.builder()
                .firstname("iza")
                .lastname("elk")
                .build();

        TalkDto cognitoTalk = TalkDto.builder()
                .title("AWS Cognito")
                .description("Après 2 ans à travailler sur la mise en place de cette solution au PMU, kevin llps nous présentera son retour d'expérience en détaillant les points forts et les points faibles de Cognito.")
                .date(LocalDateTime.of(2022, 10, 13, 19, 45, 0))
                .speaker(speakerKevLps)
                .build();

        TalkDto chatBotsTalk = TalkDto.builder()
                .title("Les chatbots")
                .description("Les chatbots sont un peu partout aujourd'hui. Voyons le pourquoi du comment et réalisons-en un avec Google DialogFlow, pour aider nos chers formateurs à se libérer des questions les plus fréquentes.")
                .date(LocalDateTime.of(2022, 10, 13, 19, 0, 0))
                .speaker(speakerCharLcs)
                .build();

        TalkDto videoGamesTalk = TalkDto.builder()
                .title("Mécanismes d'un bon jeu vidéo")
                .description("Passionné de jeux vidéo ou juste curieux de comprendre pourquoi ton copain ou ta copine passe toute ses soirées devant son écran au lieu de venir regarder Top Chef avec toi ? Je te conseille de venir écouter cette conférence pour comprendre une partie des mystères qui entourent l'univers très vaste du jeu vidéo.")
                .date(LocalDateTime.of(2022, 10, 13, 21, 0, 0))
                .speaker(speakerIzaElk)
                .build();

        TalkDto firstPartAwsLambdaTalk = TalkDto.builder()
                .title("AWS Lambda")
                .description("A travers ce retour d'expérience, kevin llps nous présentera le service AWS Lambda et dans quel contexte l'utiliser.")
                .date(LocalDateTime.of(2022, 10, 24, 19, 0, 0))
                .speaker(speakerKevLps)
                .build();

        TalkDto secondPartAwsLambdaTalk = TalkDto.builder()
                .title("AWS Lambda - Partie 2")
                .description("Deuxième partie de la présentation sur les lambdas AWS")
                .date(LocalDateTime.of(2023, 2, 9, 19, 0, 0))
                .speaker(speakerKevLps)
                .build();

        return List.of(cognitoTalk, chatBotsTalk, videoGamesTalk, firstPartAwsLambdaTalk, secondPartAwsLambdaTalk);
    }

    public static TalkDto oneTalkDto() {
        SpeakerDto speakerKevLps = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        return TalkDto.builder()
                .title("AWS Cognito")
                .description("Après 2 ans à travailler sur la mise en place de cette solution au PMU, kevin llps nous présentera son retour d'expérience en détaillant les points forts et les points faibles de Cognito.")
                .date(LocalDateTime.of(2022, 10, 13, 19, 45, 0))
                .speaker(speakerKevLps)
                .build();
    }

}
