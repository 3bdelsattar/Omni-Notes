package it.feio.android.omninotes;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction viewInteraction = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        viewInteraction.perform(click());

        ViewInteraction viewInteraction2 = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        viewInteraction2.perform(click());

        ViewInteraction viewInteraction3 = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        viewInteraction3.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_note),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                2),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.detail_title),
                        childAtPosition(
                                allOf(withId(R.id.title_wrapper),
                                        childAtPosition(
                                                withId(R.id.detail_tile_card),
                                                0)),
                                1),
                        isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.detail_title),
                        childAtPosition(
                                allOf(withId(R.id.title_wrapper),
                                        childAtPosition(
                                                withId(R.id.detail_tile_card),
                                                0)),
                                1),
                        isDisplayed()));
        editText2.perform(replaceText("Test title"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.detail_content),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_detail_content),
                                        1),
                                0)));
        editText3.perform(scrollTo(), replaceText("Test content"), closeSoftKeyboard());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.reminder_layout),
                        childAtPosition(
                                allOf(withId(R.id.fragment_detail_content),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                2)));
        linearLayout.perform(scrollTo(), click());

        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.minutes), withText("35"),
                        childAtPosition(
                                allOf(withId(R.id.time_header),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.buttonSwitcher), withText("Mar 14, 2021"),
                        childAtPosition(
                                allOf(withId(R.id.button_layout),
                                        childAtPosition(
                                                withId(R.id.llMainContentHolder),
                                                2)),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonPositive), withText("Ok"),
                        childAtPosition(
                                allOf(withId(R.id.button_layout),
                                        childAtPosition(
                                                withId(R.id.llMainContentHolder),
                                                2)),
                                5),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                4),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_category), withContentDescription("Category"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                1),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("drawer open"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction viewInteraction4 = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        viewInteraction4.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab_checklist),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                1),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.detail_title),
                        childAtPosition(
                                allOf(withId(R.id.title_wrapper),
                                        childAtPosition(
                                                withId(R.id.detail_tile_card),
                                                0)),
                                1),
                        isDisplayed()));
        editText4.perform(replaceText("What to do 2day"), closeSoftKeyboard());

        ViewInteraction editTextMultiLineNoEnter = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("it.feio.android.checklistview.models.CheckListViewItem")),
                                0),
                        2),
                        isDisplayed()));
        editTextMultiLineNoEnter.perform(replaceText("Take meds "), closeSoftKeyboard());

        ViewInteraction editTextMultiLineNoEnter2 = onView(
                allOf(withText("Take meds "),
                        childAtPosition(
                                childAtPosition(
                                        withText("Take meds "),
                                        0),
                                2),
                        isDisplayed()));
        editTextMultiLineNoEnter2.perform(pressImeActionButton());

        ViewInteraction editTextMultiLineNoEnter3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("it.feio.android.checklistview.models.CheckListViewItem")),
                                0),
                        2),
                        isDisplayed()));
        editTextMultiLineNoEnter3.perform(replaceText("Take drugs "), closeSoftKeyboard());

        ViewInteraction editTextMultiLineNoEnter4 = onView(
                allOf(withText("Take drugs "),
                        childAtPosition(
                                childAtPosition(
                                        withText("Take drugs "),
                                        0),
                                2),
                        isDisplayed()));
        editTextMultiLineNoEnter4.perform(pressImeActionButton());

        ViewInteraction editTextMultiLineNoEnter5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("it.feio.android.checklistview.models.CheckListViewItem")),
                                0),
                        2),
                        isDisplayed()));
        editTextMultiLineNoEnter5.perform(replaceText("Dren"), closeSoftKeyboard());

        ViewInteraction editTextMultiLineNoEnter6 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(is("it.feio.android.checklistview.models.CheckListViewItem")),
                                0),
                        2),
                        isDisplayed()));
        editTextMultiLineNoEnter6.perform(replaceText("Drive ur car \uD83D\uDE97"), closeSoftKeyboard());

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.reminder_layout),
                        childAtPosition(
                                allOf(withId(R.id.fragment_detail_content),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                2)));
        linearLayout2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonPositive), withText("Ok"),
                        childAtPosition(
                                allOf(withId(R.id.button_layout),
                                        childAtPosition(
                                                withId(R.id.llMainContentHolder),
                                                2)),
                                5),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("drawer open"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.undobar_button), withText("UNDO"),
                        childAtPosition(
                                allOf(withId(R.id.undobar),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.undobar_button), withText("UNDO"),
                        childAtPosition(
                                allOf(withId(R.id.undobar),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.root),
                        childAtPosition(
                                allOf(withId(R.id.list),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.perform(longClick());

        ViewInteraction overflowMenuButton2 = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_mode_bar),
                                        2),
                                3),
                        isDisplayed()));
        overflowMenuButton2.perform(click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(R.id.title), withText("Trash"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView2.perform(click());

        ViewInteraction overflowMenuButton3 = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                2),
                        isDisplayed()));
        overflowMenuButton3.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("drawer open"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.settings_view),
                        childAtPosition(
                                allOf(withId(R.id.left_drawer),
                                        childAtPosition(
                                                withId(R.id.navigation_drawer),
                                                0)),
                                2)));
        linearLayout3.perform(scrollTo(), click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler_view),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler_view),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(4, click()));

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recycler_view),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)));
        recyclerView4.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction viewInteraction5 = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        viewInteraction5.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab_note),
                        childAtPosition(
                                allOf(withId(R.id.fab),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                2)),
                                2),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.detail_title),
                        childAtPosition(
                                allOf(withId(R.id.title_wrapper),
                                        childAtPosition(
                                                withId(R.id.detail_tile_card),
                                                0)),
                                1),
                        isDisplayed()));
        editText5.perform(replaceText("Feel"), closeSoftKeyboard());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withContentDescription("drawer closed"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton8.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
