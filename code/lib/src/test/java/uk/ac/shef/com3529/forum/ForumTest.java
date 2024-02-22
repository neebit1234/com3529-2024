package uk.ac.shef.com3529.forum;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class ForumTest {

    @Test
    public void shouldNotLoginBannedUser() {
        // Given a forum with registered users
        Forum forum = makeForum();//DAMP not DRY should have the test clear rather than extracting into another function

        // When the user is banned
        forum.ban("billy");

        // Then the user cannot login
        boolean loggedIn = forum.login("billy");
        assertFalse(loggedIn);
    }

    @Test
    public void shouldNotLoginBannedUserImproved() {
        // Given a forum with registered users
        //Forum forum = makeForum();//DAMP not DRY should have the test clear rather than extracting into another function
        Forum forum = new Forum();
        forum.registerUser("Billy Sharp", "billy", "b.sharp@sufc.co.uk");

        // When the user is banned
        forum.ban("billy");

        // Then the user cannot login
        boolean loggedIn = forum.login("billy");
        assertFalse(loggedIn);
    }

    @Test
    public void shouldGetRegisteredUser() { //Test structured around method not behaviour
        // Given a forum
        Forum forum = new Forum();

        // When a user is registered
        forum.registerUser("John Egan", "captain", "j.egan@sufc.co.uk");

        // Then can get the user
        assertNotNull(forum.getUser("captain"));
    }

    @Test
    public void shouldRegisterNewUser() { //Test structured around method not behaviour
        // Given a forum
        Forum forum = new Forum();

        // When a user is registered
        forum.registerUser("John Egan", "captain", "j.egan@sufc.co.uk");

        // Then can get the user
        assertNotNull(forum.getUser("captain"));
    }

    @Test
    public void testBan() { //Logic in test, name test after behaviour, DAMP not DRY (makeForum() extraction)
        Forum forum = makeForum();
        for (String username : forum.getUsernames()) {
            forum.ban(username);
        }
        for (String username : forum.getUsernames()) {
            User user = forum.getUser(username);
            assertTrue(user.isBanned());
        }
    }

    @Test
    public void shouldBanUser() {
        //Register a new user
        Forum forum = new Forum();
        forum.registerUser("Billy Sharp", "billy", "b.sharp@sufc.co.uk");

        //Ban User
        forum.ban("billy");//Use "billy" instead of a variable to follow easier

        User user = forum.getUser("billy");//extract so that the assert is easier to read
        assertTrue(user.isBanned());
    }

    @Test
    public void testGetMostProfilicPoster() {//DAMP not DRY (makeForum() and makePosts() extraction), Name tests after behaviour tested (also typo)
        Forum forum = makeForum();
        makePosts(forum);
        assertThat(forum.getUser(forum.getMostProlificUser()).numPostsMade(), equalTo(2));//kind of clunky only really need the user
    }

    @Test
    public void shouldFindMostProlificPoster() {//DAMP not DRY (makeForum() and makePosts() extraction), Name tests after behaviour tested
        //Add user to a forum only add those used
        Forum forum = new Forum();
        forum.registerUser("Billy Sharp", "billy", "b.sharp@sufc.co.uk");
        forum.registerUser("Chris Basham", "bash", "c.basham@sufc.co.uk");

        //Add posts to forum
        forum.post("bash", "Billy Sharp scores goals", "We got Billy Sharp, Billy Sharp. We got Billy Sharp");
        forum.post("bash", "Boxing Day", "Hark now hear, United sing, the Wednesday Ran Away");
        forum.post("billy", "Bladesmen", "We are Bladesmen, super Bladesmen, we are Blademen, from the Lane");

        //Most prolific poster should be bash
        // Previous was not concise, went around in circles calling methods
        assertThat(forum.getMostProlificUser(), equalTo("bash"));
    }

    Forum makeForum() {
        Forum forum = new Forum();
        forum.registerUser("Billy Sharp", "billy", "b.sharp@sufc.co.uk");
        forum.registerUser("Iliman NDiaye", "ili", "i.ndiaye@sufc.co.uk");
        forum.registerUser("Chris Basham", "bash", "c.basham@sufc.co.uk");
        return forum;
    }

    void makePosts(Forum forum) {
        forum.post("bash", "Billy Sharp scores goals", "We got Billy Sharp, Billy Sharp. We got Billy Sharp");
        forum.post("bash", "Boxing Day", "Hark now hear, United sing, the Wednesday Ran Away");
        forum.post("billy", "Bladesmen", "We are Bladesmen, super Bladesmen, we are Blademen, from the Lane");
    }
}
