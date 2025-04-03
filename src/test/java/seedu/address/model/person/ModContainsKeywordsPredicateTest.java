package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class ModContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        ModContainsKeywordsPredicate firstPredicate =
                new ModContainsKeywordsPredicate(firstPredicateKeywordList);
        ModContainsKeywordsPredicate secondPredicate =
                new ModContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ModContainsKeywordsPredicate firstPredicateCopy =
                new ModContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        ModContainsKeywordsPredicate predicate =
                new ModContainsKeywordsPredicate(Collections.singletonList("CS2103T"));
        assertTrue(predicate.test(new PersonBuilder().withLink(
                "https://nusmods.com/timetable/sem-2/share?CS2101=&CS2103T=LEC:G12")
                .build()));

        // Multiple keywords
        predicate = new ModContainsKeywordsPredicate(Arrays.asList("CS2103T", "CS2101"));
        assertTrue(predicate.test(new PersonBuilder().withLink(
                "https://nusmods.com/timetable/sem-2/share?CS2101=&CS2103T=LEC:G12")
                .build()));

        // Only one matching keyword
        predicate = new ModContainsKeywordsPredicate(Arrays.asList("CS2103T", "CS2040"));
        assertTrue(predicate.test(new PersonBuilder().withLink(
                "https://nusmods.com/timetable/sem-2/share?CS2101=&CS2103T=LEC:G12")
                .build()));

        // Mixed-case keywords
        predicate = new ModContainsKeywordsPredicate(Arrays.asList("cs2103t", "cS2040"));
        assertTrue(predicate.test(new PersonBuilder().withLink(
                "https://nusmods.com/timetable/sem-2/share?CS2101=&CS2103T=LEC:G12")
                .build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        ModContainsKeywordsPredicate predicate =
                new ModContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder()
                .withLink("https://nusmods.com/timetable/sem-2/share?CG1111=LEC:1,TUT:1").build()));

        // Non-matching keyword
        predicate = new ModContainsKeywordsPredicate(Arrays.asList("CS3233"));
        assertFalse(predicate.test(new PersonBuilder().withLink(
                "https://nusmods.com/timetable/sem-2/share?CS2101=&CS2103T=LEC:G12")
                .build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        ModContainsKeywordsPredicate predicate = new ModContainsKeywordsPredicate(keywords);

        String expected = ModContainsKeywordsPredicate.class.getCanonicalName() + "{keywords="
                + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
