Image Viewer Application
This repository contains an image viewer application designed to load, display, and navigate through images. It's structured into several packages to organize different functionalities.

Structure:
  software.ulpgc.imageviewer
    •	image: Defines the Image interface representing an image with its ID and navigation methods.
    •	imagedisplay: Specifies the ImageDisplay interface for displaying images.
    •	imageloader: Defines the ImageLoader interface responsible for loading images.
    •	main: Contains the Main class to execute the application.
  
  software.ulpgc.imageviewer.mocks
    •	mockimageloader: Provides a MockImageLoader implementation for loading mock images.
      software.ulpgc.imageviewer.real
    •	guiimagedisplay: Implements ImageDisplay for displaying images in a GUI.
    •	imagepresenter: Implements the logic to present and navigate through images.
    
  How to Use:
    1. Setup and Loading Images
      1.	Prepare Images: Place your images in a directory within the project (e.g., images/).
        •	Image Format: Ensure images are in a compatible format (e.g., JPG, PNG).
        •	Multiple Images: You can add multiple images for testing navigation functionality.
      2.	Update Image Paths:
        •	Locate the MockImageLoader class (software.ulpgc.imageviewer.mocks package).
        •	Modify the IMAGE_PATH variable in MockImageLoader to point to your image directory.
    Example:
    private final String IMAGE_PATH = "images/"; // Update this path 
    2. Displaying Images
      1.	Run the Application:
        •	Execute the Main.java file to start the application.
      2.	Navigation:
        •	Use the "Previous" and "Next" buttons in the GUI to navigate between images.
        •	Verify the functionality with multiple images by clicking the navigation buttons.
