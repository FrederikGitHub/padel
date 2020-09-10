import { SideNavItems, SideNavSection } from '@modules/navigation/models';

export const sideNavSections: SideNavSection[] = [
    {
        text: 'CORE',
        items: ['dashboard'],
    },
    {
        text: 'ADMIN',
        items: ['members', 'timeslots', 'poule', 'group', 'court'],
    },
    {
        text: 'RESERVATIES',
        items: ['generate', 'weekReservations','courtReservations','myReservations'],
    },
    {
        text: 'POULES',
        items: ['admin', 'results'],
    },
    {
        text: 'STATISTIEKEN',
        items: ['charts'],
    },
];

export const sideNavItems: SideNavItems = {
    dashboard: {
        icon: 'tachometer-alt',
        text: 'Dashboard',
        link: '/dashboard',
    },
    charts: {
        icon: 'chart-area',
        text: 'Statistieken',
        link: '/stats',
    },
    admin: {
        icon: 'chart-area',
        text: 'Beheer',
        link: '/poules/admin',
    },
    results: {
        icon: 'table',
        text: 'Uitslagen',
        link: '/poules/results',
    },

    members: {
        icon: 'user',
        text: 'Leden',
        link: '/admin/members',
    },
    timeslots: {
        icon: 'clock',
        text: 'Timeslots',
        link: '/admin/timeslots',
    },
    poule: {
        icon: 'table',
        text: 'Poules',
        link: '/admin/poule',
    },
    group: {
        icon: 'user-friends',
        text: 'Groepen',
        link: '/admin/group',
    },
    court: {
        icon: 'map',
        text: 'Terreinen',
        link: '/admin/court',
    },
    generate: {
        icon: 'robot',
        text: 'Auto reservaties',
        link: '/reservations/auto',
    },
    weekReservations: {
        icon: 'calendar-week',
        text: 'Week reservaties',
        link: '/reservations/week',
    },
    courtReservations: {
        icon: 'calendar-day',
        text: 'Terrein reservaties',
        link: '/reservations/court',
    },
    myReservations: {
        icon: 'user-clock',
        text: 'Mijn reservaties',
        link: '/reservations/my',
    },

};
