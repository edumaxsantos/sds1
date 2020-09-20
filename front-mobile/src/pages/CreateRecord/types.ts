export type GamePlatform = 'XBOX' | 'PLAYSTATION' | 'PC';

export type Game = {
  id: number;
  title: string;
  platform: GamePlatform;
  label: string;
  value: number;
};