**PDF Validator Utility**
The PDF Validator Utility is a tool developed using the Qoppa PDF library in Java. This utility is designed to validate PDF files by checking their content and identifying any blank pages. The required JAR files for the Qoppa PDF library can be downloaded from [here](https://www.qoppa.com/download2018r1/).

**Overview**
The utility works as follows:

**Download PDF File**: The entry point function takes either the file URL or the file name from which the PDF needs to be downloaded. Selenium is utilized to initiate the file download if the PDF is hosted on a server.

**PDF Validation**: Once the PDF file is downloaded, it is passed to the pdfValidation function. This function performs various actions on the PDF, including content validation and checking for blank pages. Based on these checks, the utility provides validation results.

**Getting Started**
To use this utility in your project, you will need to include the required Qoppa PDF library JAR files. Make sure to download them from the official Qoppa website and include them in your project's classpath.

**Documentation**
For detailed information on the functionalities and usage of the Qoppa PDF library, refer to the comprehensive documentation available on the Qoppa website.

