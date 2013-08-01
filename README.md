# Logging Example

This project shows a really simple WAR which uses the provided *slf4j* logging
framework.

Note that this project contains absolutely no target specific config files,
nor does it contain log configuration files.

Keep life easy.

This was tested on jboss-6.1.0.Final.

## Principle

It depends on the slf4j-api with scope *provided*

For testing purposes the slf4j-log4j and log4j was added in the scope *test*.

To use this just add a minimal log4j.xml in *src/test/resources* and Bob's your
uncle.

I purposely left out the test part to show nothing of the sort is *needed*.

# Results

## JBoss-6.1.0

I deployed the exploded war. Went to http;//localhost:8080/logexample/hello and
refreshed the page.

On the jboss output arrived :

    14:39:51,707 INFO  [ ... .logexample.HelloServlet] Entering hello servlet
    14:39:51,708 INFO  [ ... .logexample.HelloServlet] Leaving hello servlet
    17:02:38,469 INFO  [ ... .logexample.HelloServlet] Entering hello servlet
    17:02:38,474 INFO  [ ... .logexample.HelloServlet] Leaving hello servlet


I cut the loglines a bit so they fit on a line

## karaf-2.3.2

Started karaf, installed the war feature bundle to deploy wars.

    karaf@root> features:install war


Chucked the logexample.war in the deploy folder.

I went to http://localhost:8181/logexample/hello and refreshed the page

    karaf@root> display | grep HelloServlet
    2013-08-01 ... .example.logexample.HelloServlet ...  Entering hello servlet
    2013-08-01 ... .example.logexample.HelloServlet ...  Leaving hello servlet
    2013-08-01 ... .example.logexample.HelloServlet ...  Entering hello servlet
    2013-08-01 ... .example.logexample.HelloServlet ...  Leaving hello servlet

I cut the loglines a bit so they fit on a line

So it should also work just fine under servicemix, which is just a souped up
karaf after all.

## JBoss AS 7.1.1

Started JBoss. Logged in to the management console. Uploaded *logexample.war*
from the target folder to the JBoss deployments and enabled it.

Went to http;//localhost:8080/logexample/hello and
refreshed the page.

On the jboss output arrived :

    17:21:04,825 INFO  [ ... .HelloServlet] (...) Entering hello servlet
    17:21:04,825 INFO  [ ... .HelloServlet] (...) Leaving hello servlet
    17:21:16,761 INFO  [ ... .HelloServlet] (...) Entering hello servlet
    17:21:16,761 INFO  [ ... .HelloServlet] (...) Leaving hello servlet

nice

# Conclusion

Do less, get more. Just use the SLF4J facade offered by the containers. No need
for fancy configurations, keep life easy.

However, for real projects, check that there are no logging frameworks sneaking
in through the backdoor. If one package pulls in another logging implementation,
or a developer temporarily adds one (why, I would not know) then all bets are
off.

