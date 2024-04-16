# hexagonal-conference-event-reminder

This project was designed to manage various conference events
in order to remind upcoming events.

The application is implemented by using hexagonal architecture.
You can found [here](https://github.com/kevin-llps/conference-event-reminder) the same project using layers
architecture.

# Paris JUG / Devoxx France 2024 Demo

During Paris JUG session (2024-01-09) and Devoxx France 2024 (2024-04-18), hexagonal architecture was implemented step by step.
The initial application is only supporting Talks (current branch is supporting Talks, BBLs and Practice sessions).

- Final solution can be found [here](https://github.com/kevin-llps/hexagonal-conference-event-reminder/tree/demo-paris-jug-solution).
- Initial application before "step by step" migration can be found [here](https://github.com/kevin-llps/hexagonal-conference-event-reminder/tree/demo-paris-jug-todo).

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