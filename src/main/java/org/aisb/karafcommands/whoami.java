
package org.aisb.karafcommands;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import java.util.Set;

import java.security.*;
import javax.security.auth.Subject;

@Command(scope = "aisb", name = "whoami", description = "List currently active principals according to JAAs.")
@Service
public class whoami implements Action {

    @Override
    public Object execute() throws Exception {
	// Get the currently-active JAAS Subject.
	AccessControlContext acc = AccessController.getContext();
	Subject subj = Subject.getSubject(acc);

	Set<Principal> principals = subj.getPrincipals();

	System.out.println("-----");
	for (Principal p : principals) {
	    System.out.print("Principal Class: ");
	    System.out.println(p.getClass());
	    System.out.println("Principal: ");
	    System.out.println(p);
	    System.out.println("-----");
	}

	return null;
    }
}
