package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.TalkDto;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static fr.kevin.llps.conf.event.reminder.api.rest.samples.TalkSample.talkList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TalkDtoMapperTest {

    @Mock
    private SpeakerDtoMapper speakerMapper;

    @InjectMocks
    private TalkDtoMapper talkMapper;

    @Test
    void shouldMapToDtoList() {
        List<Talk> talks = talkList();

        Speaker speakerKevLps = new Speaker("kevin", "llps");
        Speaker speakerCharLcs = new Speaker("charlie", "lcs");
        Speaker speakerIzaElk = new Speaker("iza", "elk");

        SpeakerDto speakerKevLpsDto = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        SpeakerDto speakerCharLcsDto = SpeakerDto.builder()
                .firstname("charlie")
                .lastname("lcs")
                .build();

        SpeakerDto speakerIzaElkDto = SpeakerDto.builder()
                .firstname("iza")
                .lastname("elk")
                .build();

        when(speakerMapper.mapToDto(speakerKevLps)).thenReturn(speakerKevLpsDto);
        when(speakerMapper.mapToDto(speakerCharLcs)).thenReturn(speakerCharLcsDto);
        when(speakerMapper.mapToDto(speakerIzaElk)).thenReturn(speakerIzaElkDto);

        List<TalkDto> talkDtoList = talkMapper.mapToDtoList(talks);

        assertThat(talkDtoList).isNotNull()
                .hasSize(5)
                .extracting("title", "description", "date", "speaker.firstname", "speaker.lastname")
                .containsExactlyInAnyOrder(
                        tuple("AWS Cognito",
                                "Après 2 ans à travailler sur la mise en place de cette solution au PMU, kevin llps nous présentera son retour d'expérience en détaillant les points forts et les points faibles de Cognito.",
                                LocalDateTime.of(2022, 10, 13, 19, 45, 0),
                                "kevin", "llps"),
                        tuple("Les chatbots",
                                "Les chatbots sont un peu partout aujourd'hui. Voyons le pourquoi du comment et réalisons-en un avec Google DialogFlow, pour aider nos chers formateurs à se libérer des questions les plus fréquentes.",
                                LocalDateTime.of(2022, 10, 13, 19, 0, 0),
                                "charlie", "lcs"),
                        tuple("Mécanismes d'un bon jeu vidéo",
                                "Passionné de jeux vidéo ou juste curieux de comprendre pourquoi ton copain ou ta copine passe toute ses soirées devant son écran au lieu de venir regarder Top Chef avec toi ? Je te conseille de venir écouter cette conférence pour comprendre une partie des mystères qui entourent l'univers très vaste du jeu vidéo.",
                                LocalDateTime.of(2022, 10, 13, 21, 0, 0),
                                "iza", "elk"),
                        tuple("AWS Lambda",
                                "A travers ce retour d'expérience, kevin llps nous présentera le service AWS Lambda et dans quel contexte l'utiliser.",
                                LocalDateTime.of(2022, 10, 24, 19, 0, 0),
                                "kevin", "llps"),
                        tuple("AWS Lambda - Partie 2",
                                "Deuxième partie de la présentation sur les lambdas AWS",
                                LocalDateTime.of(2023, 2, 9, 19, 0, 0),
                                "kevin", "llps"));
    }

}
