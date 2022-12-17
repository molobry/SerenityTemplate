### Application code
 
These packages generally contain application code. 
If you are writing a reusable test library, you can also place reusable test components such as Page Objects or Tasks here.

In case of problem with running locally with Cucumber please check and edit configuration and make sure that
Main class instead of io.cucumber.core.cli.Main is net.serenitybdd.cucumber.cli.Main
Sometimes io.cucumber.core.cli.Main works fine. I still don't know why sometimes we need to change main class.