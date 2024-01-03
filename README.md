# hexagonal-conference-event-reminder

This project was designed to manage various conference events
in order to remind upcoming events.

The application is implemented by using hexagonal architecture.
You can found [here](https://github.com/kevin-llps/conference-event-reminder) the same project using layers architecture. 

## Events

| Event name       | Description                                                                                     |
|------------------|-------------------------------------------------------------------------------------------------|
| Talk             | Public talk animated by a speaker                                                               |
| BBL              | Brown Bag Lunches, it consists to present a talk dedicated to a company (in return for a lunch) |
| Practice session | It aims to teach and let a small group of attendees practice                                    |

## API REST

- POST /events/import
- GET /events/upcoming
- GET /events/export