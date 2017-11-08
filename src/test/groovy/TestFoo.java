import java.nio.file.Files;
import masonwan.gradle.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Foo.class,
})
public class TestFoo {

  @Test
  public void name() throws Exception {
    PowerMockito.mockStatic(Files.class);
    PowerMockito.when(Files.exists(any()))
        .thenThrow(new RuntimeException("no pass"));

    assertThatThrownBy(() -> {
      Foo.exists();
    })
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("no pass");
  }
}
