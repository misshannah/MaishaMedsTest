package com.hannah.testmeds;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.hannah.testmeds.ui.HomePage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class HomePageUITest {
    @Rule
    public ActivityScenarioRule activityTestRule = new ActivityScenarioRule<>(HomePage.class);

    @Before
    public void launchActivity() {
        ActivityScenario.launch(HomePage.class);
    }
    @Test
    public void recyclerViewContent() {
        onView(withId(R.id.posts_recyclerView)).check(matches(notNullValue()));

    }

}
