export const menuItems = [
    {
        name: "Dashboard",
        exact: true,
        to: "/",
        iconClassName: "bi bi-speedometer2",
    },
    {
        name: "Content",
        exact: true,
        to: `/content`,
        iconClassName: "bi bi-speedometer2",
        subMenus: [
            { name: "Courses", to: "/content/courses" },
            { name: "Videos", to: "/content/videos" },
        ],
    },
    { name: "Design", to: `/design`, iconClassName: "bi bi-vector-pen" },
    {
        name: "Content 2",
        exact: true,
        to: `/content-2`,
        iconClassName: "bi bi-speedometer2",
        subMenus: [
            { name: "Courses", to: "/content-2/courses" },
            { name: "Videos", to: "/content-2/videos" },
        ],
    },
    { name: "Design 2", to: `/design-2`, iconClassName: "bi bi-vector-pen" },
    { name: "Design 3", to: `/design-3`, iconClassName: "bi bi-vector-pen" },
    { name: "Design 4", to: `/design-4`, iconClassName: "bi bi-vector-pen" },
];