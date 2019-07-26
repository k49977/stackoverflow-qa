package com.github.yukihane.so56891;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringRunner.class)
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ServiceImplTest {
    @Mock
    private Repository rep;

    @InjectMocks
    private ServiceImpl service;

    @Test
    public void testInsertError01() {
        boolean actual = false;
        try {
            // TODO:throwされない
            doThrow(new NullPointerException()).when(rep).saveAndFlush(new UserMst());
            actual = service.insert("user");
        } catch (Exception e) {
        }
        assertThat(actual).isEqualTo(false); // 結果がtrueとなるためNG
    }
}
