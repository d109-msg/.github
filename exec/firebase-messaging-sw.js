// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here. Other Firebase libraries

// are not available in the service worker.
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-messaging.js');
// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
firebase.initializeApp({
apiKey: "${FIREBASE_API_KEY}",
  authDomain: "{AUTH_DOMAIN}",
  projectId: "{PROJECT_ID}",
  storageBucket: "${STORAGE_BUCKET}",
messagingSenderId: "${MESSAGING_SENDER_ID}",
appId: "{APP_ID}",
measurementId: "{MEASUREMENT_ID}"
});

const messaging = firebase.messaging();

messaging.onBackgroundMessage((payload) => {
console.log('[firebase-messaging-sw.js] Received background message ', payload);
const notificationTitle = payload.data.title;
const notificationOptions = {
body: payload.data.body,
// icon: './MSG_logo_blue_image_dark.png'

};

console.log(notificationTitle, notificationOptions)
self.registration.showNotification(notificationTitle, notificationOptions);
});

self.addEventListener('notificationclick', function(event) {
console.log('[firebase-messaging-sw.js] Notification click Received.', event.notification.data);

// 알림창 닫기
event.notification.close();
// 알림 클릭 시 페이지 열기
const clickResponsePromise = clients.openWindow('${DOMAIN}');
event.waitUntil(clickResponsePromise);
});
