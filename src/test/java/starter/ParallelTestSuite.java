package starter;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "")
@ExcludeTags("ignore")
public class ParallelTestSuite {}
