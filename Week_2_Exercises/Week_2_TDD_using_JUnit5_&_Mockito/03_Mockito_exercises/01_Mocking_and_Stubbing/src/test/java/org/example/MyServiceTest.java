package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Mock the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the getData() method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert the mocked result
        assertEquals("Mock Data", result);
    }
}
