import threading
import requests

# The URL to send requests to
url = "http://localhost:8081/api/products"

# Function to send a request and print the response


def fetch_data(thread_id):
    try:
        response = requests.get(url)
        print(f"Thread {thread_id}: {response.status_code} - {response.text}")
    except requests.RequestException as e:
        print(f"Thread {thread_id}: Error - {e}")


# List to hold threads
threads = []

# Create and start 10 threads
for i in range(50):
    thread = threading.Thread(target=fetch_data, args=(i,))
    threads.append(thread)
    thread.start()

# Wait for all threads to complete
for thread in threads:
    thread.join()

print("All requests completed.")
