let globalArray = [];

function addDataToGlobalArray() {
    const newData = new Array(1000000).fill('Some data'); // Create a large array
    globalArray.push(newData); // Push it into the global array
}

// Simulate adding data over time (e.g., every second)
setInterval(addDataToGlobalArray, 1000);
