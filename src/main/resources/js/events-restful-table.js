AJS.$(document).ready(function () {
    new AJS.RestfulTable({
        autoFocus: true,
        el: jQuery("#event-rt"),
        resources: {
            all: AJS.contextPath() + "/rest/evt-restful-table/1.0/events-restful-table/all",
            self: AJS.contextPath() + "/rest/evt-restful-table/1.0/events-restful-table/self"
        },
        columns: [
            {
                id: "name",
                header: "Event name"
            },
            {
                id: "salary",
                header: "salary"
            },
            {
                id: "closedClockFix",
                header: "closedClockFix",
            },
            {
                id: "rollingHours",
                header: "rollingHours"
            }
        ]
    });
});

