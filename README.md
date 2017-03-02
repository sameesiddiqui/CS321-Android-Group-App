# CS321-Android-Group-App
Iris - Morning Assistant

Iris is a morning assistant that simplifies your day: everything from your alarm, calendar events, and the weather are easily accessible in one, easy to use interface. No more looking through several apps to obtain the desired information - once you turn off your morning alarm, Iris presents you this information about the upcoming day.

Functional Requirements - Provide a prioritized and approximately estimated list of functional requirements for the system. Describe each requirement briefly and state the rationale for including that requirement. Also, describe the prioritization and estimation schemes used.
Task: Alarm Clock - Setting and ability to turn off
User needs to be able to set an alarm with the option to repeat on specific days
The app needs to activate after the alarm is turned off
This requirement is at the top, as it is needed for the app to start. It is also one of the features needed for our Minimum Viable Product. 
Task: Calendar
Display next event in order of priority.
Display all events for the day from your google calendar
This requirement is second on our priority list since this information will be what the user will be most concerned about relating to their day.
Task: Gather Weather App Info
Display information for today in the Weather widget
Displays expanded information after the widget has been pressed
This requirement is near the top as it is also apart of our core desired information.

Extra:
Task: Implement Text to Speech
Read out the selected information to the user
This requirement is lower in our list because we want to focus on compiling the information in one place first, before adding this extra feature.
Task: To-Do List
Display any items you have marked at ‘to-do’ by the end of the day, or reminders you have set.
Similar to implementing the google calendar, we will add the option to implement reminders from Google Keep, since Google Keep and Google Calendar already work well together.
This requirement is second on our extras list because once we have text-to-speech working, the next most important information a user would desire would be items the person already wants to be reminded about. 
Task: Random Compliment/Tip*
Deliver a tip or complement to the user at the conclusion of the daily digest.
This is our lowest priority requirement, since this information doesn’t actually relate to the user’s day, however it would be fairly simple to implement once text-to-speech is set up.

List of non-functional requirements - Identify the non-functional requirements for the system. Record any constraints that these requirements may place on the system to be built. 

Interoperability: Iris is capable of using information stored in other apps, combine it and present it to the user in an effective manner, thus making it interoperable.
Information should be gathered, without causing a noticeable delay from the user perspective.
Accessibility: Iris is readily available to use as soon as you wake up. It doesn’t require multiple steps to be able to use it, just turning the alarm off activates the app. 
All main features should be no more than two taps away from the main screen
Efficiency: Iris efficiently presents the information in orderly manner based on user’s priority. 
Less than 1+0.25*(# of tasks/events) minutes
Reliability : Iris is reliable in the sense that the information doesn’t change when the data is merged from various apps, also the alarm clock works accurately
Data should only change, when specified by the user
The app should perform the intended functions, when required
