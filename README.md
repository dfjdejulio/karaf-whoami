# karaf-whoami
I needed a "whoami" command to debug Karaf/JAAS integration, so I made it.

The Maven "site" for this project should be visible here: <https://dfjdejulio.github.io/karaf-whoami/>

Installing this adds the "jaas:whoami" command to Karaf.  Internally,
it uses standard JAAS methods to retreive the current Subject, and
pulls all the Principals out of it.  By default, it only pulls out
versions of Karaf's UserPrincipal.  If you give it the "-g" or "-r"
switch, it will pull out Karaf's group or role principals instead, and
if you use the "-a" switch, it will pull out all principals -- even
the ones Karaf doesn't have a direct understanding of, like Kerberos
principals -- and adds a column to the table so you can see the class
of each principal.

Note: I'm currently working on submitting a pull request upstream so
this functionality is built into Karaf in the future.  If it's
accepted, this project will become pointless.
