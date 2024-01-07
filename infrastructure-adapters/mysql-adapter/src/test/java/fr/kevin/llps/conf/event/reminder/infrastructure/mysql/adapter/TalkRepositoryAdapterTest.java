package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.TalkMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.TalkRepository;
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
class TalkRepositoryAdapterTest {

    @Mock
    private TalkRepository talkRepository;

    @Mock
    private TalkMapper talkMapper;

    @InjectMocks
    private TalkRepositoryAdapter talkRepositoryAdapter;

    @Test
    void shouldFindAllOrderedByDate() {
        List<TalkEntity> talkEntities = talkEntities();
        List<Talk> expectedTalks = talkList();

        when(talkRepository.findAllOrderedByDate()).thenReturn(talkEntities);
        when(talkMapper.mapToDomain(talkEntities)).thenReturn(expectedTalks);

        List<Talk> talks = talkRepositoryAdapter.findAllOrderedByDate();

        assertThat(talks).containsExactlyInAnyOrderElementsOf(expectedTalks);

        verifyNoMoreInteractions(talkRepository, talkMapper);
    }

}
