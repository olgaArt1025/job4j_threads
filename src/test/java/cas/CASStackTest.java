package cas;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class CASStackTest {

    @Test
    public void when3PushThen3Poll() {
        CASStack<Integer> stack = new CASStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
