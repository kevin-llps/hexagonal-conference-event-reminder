package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.samples;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;

import java.time.LocalDateTime;
import java.util.List;

public class TalkSample {

    public static List<Talk> talkList() {
        Speaker speakerKevLps = new Speaker("kevin", "llps");

        Talk cognitoTalk = new Talk(
                "AWS Cognito",
                "Après 2 ans à travailler sur la mise en place de cette solution au PMU, kevin llps nous présentera son retour d'expérience en détaillant les points forts et les points faibles de Cognito.",
                LocalDateTime.of(2022, 10, 13, 19, 45, 0),
                speakerKevLps);

        Talk chatBotsTalk = new Talk(
                "Les chatbots",
                "Les chatbots sont un peu partout aujourd'hui. Voyons le pourquoi du comment et réalisons-en un avec Google DialogFlow, pour aider nos chers formateurs à se libérer des questions les plus fréquentes.",
                LocalDateTime.of(2022, 10, 13, 19, 0, 0),
                new Speaker("charlie", "lcs"));

        Talk videoGamesTalk = new Talk(
                "Mécanismes d'un bon jeu vidéo",
                "Passionné de jeux vidéo ou juste curieux de comprendre pourquoi ton copain ou ta copine passe toute ses soirées devant son écran au lieu de venir regarder Top Chef avec toi ? Je te conseille de venir écouter cette conférence pour comprendre une partie des mystères qui entourent l'univers très vaste du jeu vidéo.",
                LocalDateTime.of(2022, 10, 13, 21, 0, 0),
                new Speaker("iza", "elk"));

        Talk firstPartAwsLambdaTalk = new Talk(
                "AWS Lambda",
                "A travers ce retour d'expérience, kevin llps nous présentera le service AWS Lambda et dans quel contexte l'utiliser.",
                LocalDateTime.of(2022, 10, 24, 19, 0, 0),
                speakerKevLps);

        Talk secondPartAwsLambdaTalk = new Talk(
                "AWS Lambda - Partie 2",
                "Deuxième partie de la présentation sur les lambdas AWS",
                LocalDateTime.of(2023, 2, 9, 19, 0, 0),
                speakerKevLps);

        return List.of(cognitoTalk, chatBotsTalk, videoGamesTalk, firstPartAwsLambdaTalk, secondPartAwsLambdaTalk);
    }

    public static Talk oneTalk() {
        return new Talk(
                "AWS Cognito",
                "Après 2 ans à travailler sur la mise en place de cette solution au PMU, kevin llps nous présentera son retour d'expérience en détaillant les points forts et les points faibles de Cognito.",
                LocalDateTime.of(2022, 10, 13, 19, 45, 0),
                new Speaker("kevin", "llps"));
    }

}
