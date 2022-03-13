package cas;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CASCountTest {

    @Test
    public void when2IncrementThen2Get() {
        CASCount casCount = new CASCount();
        casCount.increment();
        casCount.increment();
        assertThat(casCount.get(), is(2));
    }
}
