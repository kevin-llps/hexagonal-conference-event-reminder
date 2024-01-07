package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static fr.kevin.llps.conf.event.reminder.domain.samples.TalkSample.talkList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TalkServiceTest {

    @Mock
    private TalkRepositoryPort talkRepositoryPort;

    @InjectMocks
    private TalkService talkService;

    @Test
    void shouldGetTalks() {
        List<Talk> expectedTalks = talkList();

        when(talkRepositoryPort.findAllOrderedByDate()).thenReturn(expectedTalks);

        List<Talk> talks = talkService.getTalks();

        assertThat(talks).containsExactlyInAnyOrderElementsOf(expectedTalks);

        verifyNoMoreInteractions(talkRepositoryPort);
    }

}
