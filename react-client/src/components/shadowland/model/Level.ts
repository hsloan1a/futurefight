import {LevelWinDetails} from "./LevelWinDetails";

export interface Level {
    id?: number,
    previously_won?: LevelWinDetails,
    floor_type: string,
    level: number,
    character_portrait: string
}