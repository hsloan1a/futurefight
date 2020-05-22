import {Character} from "./Character";

export interface LevelWinDetails {
    id: number,
    notes: string,
    winning_characters: Character[],
    won_date: Date
}