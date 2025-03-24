---
layout: page
title: User Guide
---

# NUSMates

NUSMates allows NUS undergraduate students to record the contact details of their fellow NUS undergraduate students. With NUSMates, you can record NUS-specific contact information such as year, major, housing, and modules. 
NUSMates also makes it seamless to record module information using NUSMods links, helping you easily find friends who are taking the same modules - so you can form project groups, share notes, or know who to reach out to for help.

--------------------------------------------------------------------------------------------------------------------

## Table of Contents
1. [Quick Start](#quick-start)
2. [Command Summary](#command-summary)
3. [Features](#features)
    1. [Adding a contact: `add`](#adding-a-person-add)
    2. [Editing a contact: `edit`](#editing-a-person--edit)
    3. [Deleting a contact: `delete`](#deleting-a-person--delete)
    4. [Finding a contact by name: `find`](#locating-persons-by-name-find)
    5. [Finding a contact by modules: `findMod`](#locating-persons-by-module-findmod)
    6. [Listing all contacts: `list`](#listing-all-persons--list)
    7. [Clearing all contacts: `clear`](#clearing-all-entries--clear)
    8. [Exiting the app: `exit`](#exiting-the-program--exit)
    9. [Viewing help: `help`](#viewing-help--help)
4. [Troubleshooting](#troubleshooting)
    1. [Detailed installation guide](#detailed-installation-guide) 
    2. [FAQ](#faq) 
    3. [Known Issues](#known-issues) 
5. [Glossary](#glossary)

--------------------------------------------------------------------------------------------------------------------

## Quick Start
> 💡 You can quickly look up all commands in the [Command Summary](#command-summary), or check the [Glossary](#glossary) if you’re unsure about any technical terms used.
> 
> ⚠️ Having trouble installing the app or confused by any of the steps? Check out the [Detailed Installation Guide](#detailed-installation-guide) in the [Troubleshooting](#troubleshooting) section for step-by-step help.

1. Make sure you have **Java 17 or later** installed in your computer.<br>
   ⚠️ **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](#https://github.com/AY2425S2-CS2103T-T11-1/tp/releases).

3. Copy the file to the folder you want to use as the home folder for NUSMates. NUSMates will later generate files in this folder, including save data.

4. Open a command terminal and `cd` into the folder you put the jar file in.

5. Use the command `java -jar nusmates.jar` to run the application. 
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

6. Type the command in the command box and press Enter to execute it. <br>
   💡 Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe y/2 m/Computer Science` : Adds a contact named `John Doe` to NUSMates.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

7. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Command Summary
💡 For more detailed information regarding the command format and each command, refer to the [Features](#features) section.

| Command     | Format, Examples                                                                                                                                                                                                                                             |
|-------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**     | `add n/NAME p/PHONE_NUMBER e/EMAIL y/YEAR m/MAJOR h/HOUSING l/NUSMODS_LINK t/TAG…​` <br> e.g., `add n/John Doe p/98765432 e/johnd@example.com y/2 m/Computer Science  h/UTown Residence l/https://nusmods.com/timetable/sem-2/share?CS2103T=LEC:G12 t/kiasu` |
| **Edit**    | `edit INDEX n/NAME p/PHONE_NUMBER e/EMAIL y/YEAR m/MAJOR h/HOUSING l/NUSMODS_LINK t/TAG…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                                                                                              |
| **Delete**  | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                          |
| **Find**    | `find KEYWORD...`<br> e.g., `find James Jake`                                                                                                                                                                                                                |
| **FindMod** | `findMod KEYWORD...`<br> e.g., `findMod CS2103T CS2101`                                                                                                                                                                                                      |
| **List**    | `list`                                                                                                                                                                                                                                                       |
| **Clear**   | `clear`                                                                                                                                                                                                                                                      |
| **Exit**    | `exit`                                                                                                                                                                                                                                                       |
| **Help**    | `help`                                                                                                                                                                                                                                                       |

--------------------------------------------------------------------------------------------------------------------

## Features

> 💡 Notes about the command format:
> 
> * Words in `UPPER_CASE` are the parameters you must supply when entering the command.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.
>
> * Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.
> 
> * Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.
> 
> * ⚠️ If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

### Adding a person: `add`

Adds a person to NUSMates.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL y/YEAR m/MAJOR h/HOUSING l/NUSMODS_LINK t/TAG…​`

* All parameters **except for `NAME`** are optional.<br>
e.g. You can add a contact with only name, year, and major using `add n/John Doe y/2 m/Computer Science`<br>
* A person can have any number of **tags**, including none.<br>
* `LINK` refers to the student's NUSMODS course schedule original link.

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com y/2 m/Computer Science  h/UTown Residence l/https://nusmods.com/timetable/sem-2/share?CS2103T=LEC:G12`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com y/1 m/Electrical Engineering h/PGPR p/1234567 l/https://nusmods.com/timetable/sem-2/share?CS2040=TUT:12,LAB:06,LEC:1`

###
### Editing a person : `edit`

Edits an existing person in NUSMates.

Format: `edit INDEX n/NAME p/PHONE e/EMAIL y/YEAR m/MAJOR h/HOUSING l/NUSMODS_LINK t/TAG…​`

* `INDEX` refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the parameters must be provided.
* Existing values will be updated to the input values.
* For all fields except `name`, you can set it to nothing by typing the prefix without anything following it. <br>
e.g. You can remove all the person’s tags by typing `t/` without specifying any tags after it.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

###
### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

###
### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

###
### Locating persons by module: `findMod`

Finds persons who's NUSMods Link contains any of the given modules.

Format: `findMod KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `cs2030` will match `CS2030`
* The order of the keywords does not matter. e.g. `CS2030 CS2103T` will match `CS2103T CS2030`
* Only the module is searched.
* Only full words will be matched e.g. `CS2103` will not match `CS2103T`
* Persons matching at least one of the modules searched will be returned (i.e. `OR` search).

Examples:
* `findMod CS2109S` returns `Abi, Yuexi`
  ![result for 'findMod CS2109S'](images/findCS2109Sresult.png)

###
### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

###
### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

###
### Exiting the program : `exit`

Exits the program.

Format: `exit`

###
### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

--------------------------------------------------------------------------------------------------------------------

## Troubleshooting

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Glossary

--------------------------------------------------------------------------------------------------------------------
