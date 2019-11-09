# About this project

This project is based on [Azure Java Blobs quick starter](https://docs.microsoft.com/en-us/azure/storage/blobs/storage-quickstart-blobs-java-legacy), done as a demo for an Azure training.

# How to run this project

## Prerequisites

To run this demo:

* Install [Oracle JDK 11 or equivalent](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) 
* Install [Eclipse](http://www.eclipse.org/downloads/)
* Install [Maven](https://maven.apache.org/download.cgi)
* Install [Azurite](https://docs.microsoft.com/en-us/azure/storage/common/storage-use-azurite)

Install and Run Azurite:
```bash
npm install -g azurite
azurite --silent --location c:\azurite --debug c:\azurite\debug.log
```

Or if you don't have an Azure subscription, create a [free account](https://azure.microsoft.com/free/?WT.mc_id=A261C142F) before you begin.

## Create a storage account using the Azure portal

First, create a new general-purpose storage account to use for this tutorial.

* Go to the [Azure portal](https://portal.azure.com) and log in using your Azure account.
* On the Hub menu, select **New** > **Storage** > **Storage account - blob, file, table, queue**.
* Enter a name for your storage account. The name must be between 3 and 24 characters in length and may contain numbers and lowercase letters only. It must also be unique.
* Set `Deployment model` to **Resource manager**.
* Set `Account kind` to **General purpose**.
* Set `Performance` to **Standard**.
* Set `Replication` to **Locally Redundant storage (LRS)**.
* Set `Storage service encryption` to **Disabled**.
* Set `Secure transfer required` to **Disabled**.
* Select your subscription.
* For `resource group`, create a new one and give it a unique name.
* Select the `Location` to use for your storage account.
* Check **Pin to dashboard** and click **Create** to create your storage account.

After your storage account is created, it is pinned to the dashboard. Click on it to open it. Under SETTINGS, click **Access keys**. Select a key and copy the CONNECTION STRING to the clipboard, then paste it into Notepad for later use.

## Modify the connection string in the AzureApp.java file

Open this solution, and in the AzureApp.java file, change the value for connection string to the one retrieved from the portal.

At this point, you can run this application. It opens an JavaFX desktop app that let you create Azure Blob Containers, Upload files to this Container and List Container Files.