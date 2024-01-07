package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static fr.kevin.llps.conf.event.reminder.infrastructure.mysql.samples.TalkEntitySample.talkEntities;
import static fr.kevin.llps.conf.event.reminder.infrastructure.mysql.samples.TalkSample.talkList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TalkMapperTest {

    @Mock
    private SpeakerMapper speakerMapper;

    @InjectMocks
    private TalkMapper talkMapper;

    @Test
    void shouldMapToDomain() {
        List<Talk> expectedTalks = talkList();
        List<TalkEntity> talkEntities = talkEntities();

        SpeakerEntity speakerKevLpsEntity = new SpeakerEntity("kevin", "llps");
        Speaker speakerKevLps = new Speaker("kevin", "llps");

        SpeakerEntity speakerCharlicsEntity = new SpeakerEntity("charlie", "lcs");
        Speaker speakerCharlics = new Speaker("charlie", "lcs");

        SpeakerEntity speakerIzaElkEntity = new SpeakerEntity("iza", "elk");
        Speaker speakerIzaElk = new Speaker("iza", "elk");

        when(speakerMapper.mapToDomain(speakerKevLpsEntity)).thenReturn(speakerKevLps);
        when(speakerMapper.mapToDomain(speakerCharlicsEntity)).thenReturn(speakerCharlics);
        when(speakerMapper.mapToDomain(speakerIzaElkEntity)).thenReturn(speakerIzaElk);
        when(speakerMapper.mapToDomain(speakerKevLpsEntity)).thenReturn(speakerKevLps);
        when(speakerMapper.mapToDomain(speakerKevLpsEntity)).thenReturn(speakerKevLps);

        List<Talk> talks = talkMapper.mapToDomain(talkEntities);

        assertThat(talks).containsExactlyInAnyOrderElementsOf(expectedTalks);

        verifyNoMoreInteractions(speakerMapper);
    }

}
